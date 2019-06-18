package org.mino.project.ecole;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/ecoles")
public class EcoleAPI {
	
	@Autowired
	private EcoleService ecoleService;
	
    @PostMapping("/create")
    public String create(@Valid @RequestBody Ecole ecole) {
        ecoleService.createEcole(ecole);
        return "Ajout OK";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Ecole>> getAllEcole() {
        List<Ecole> listEcole = ecoleService.findAllEcole();
        if (listEcole.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(listEcole, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ecole> findById(@PathVariable Long id) {
        Optional<Ecole> ecole = ecoleService.getEcole(id);
        if (!ecole.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(ecole.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/update/{id}")
    public ResponseEntity<Ecole> update(@PathVariable Long id, @Valid @RequestBody Ecole ecole) {
        if (!ecoleService.getEcole(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ecoleService.editEcole(ecole));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!ecoleService.getEcole(id).isPresent()) {
            return "id not found";
        }
        ecoleService.deleteEcoleById(id);
        return "Delete OK";
    }
}
