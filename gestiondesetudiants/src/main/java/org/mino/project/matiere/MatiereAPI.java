/**
 * 
 */
package org.mino.project.matiere;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
@RequestMapping("/api/matieres")
public class MatiereAPI {
	
	@Autowired
	private MatiereService matiereService;	
	
    @PostMapping("/create")
    public String create(@Valid @RequestBody Matiere matiere) {
    	matiereService.createMatiere(matiere);
        return "Ajout OK";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Matiere>> getAll() {
        List<Matiere> listMatiere = matiereService.findAllMatiere();
        if (listMatiere.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(listMatiere, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Matiere> findById(@PathVariable Long id) {
        Optional<Matiere> matiere = matiereService.getMatiere(id);
        if (!matiere.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(matiere.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/update/{id}")
    public ResponseEntity<Matiere> update(@PathVariable Long id, @Valid @RequestBody Matiere matiere) {
        if (!matiereService.getMatiere(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(matiereService.editMatiere(matiere));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!matiereService.getMatiere(id).isPresent()) {
            return "id not found";
        }
        matiereService.deleteMatiereById(id);
        return "Delete OK";
    }

}
