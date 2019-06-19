/**
 * 
 */
package org.mino.project.etudiant;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mino.project.ecole.Ecole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author OneLogic
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantAPI {
	
	@Autowired
	private EtudiantService etudiantService;
	
    @PostMapping("/create")
    public String create(@Valid @RequestBody Etudiant etudiant) {
    	etudiantService.createEtudiant(etudiant);
        return "Ajout OK";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Etudiant>> getAll() {
        List<Etudiant> listEtudiant = etudiantService.findAllEtudiant();
        if (listEtudiant.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(listEtudiant, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Etudiant> findById(@PathVariable Long id) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiant(id);
        if (!etudiant.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/update/{id}")
    public ResponseEntity<Etudiant> update(@PathVariable Long id, @Valid @RequestBody Etudiant etudiant) {
        if (!etudiantService.getEtudiant(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(etudiantService.editEtudiant(etudiant));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!etudiantService.getEtudiant(id).isPresent()) {
            return "id not found";
        }
        etudiantService.deleteEtudiantById(id);
        return "Delete OK";
    }
}
