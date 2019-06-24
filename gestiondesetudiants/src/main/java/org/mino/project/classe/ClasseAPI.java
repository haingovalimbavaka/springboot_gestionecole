package org.mino.project.classe;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mino.project.Helper.ServiceHelper;
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

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClasseAPI {
	
	@Autowired
	private ClasseService classeService;
	
    @PostMapping("/create")
    public String create(@Valid @RequestBody Classe classe) {
    	classeService.createClasse(classe);
        return "Ajout OK";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Classe>> getAllClasse() {
        List<Classe> listClasse = classeService.findAllClasse();
        if (listClasse.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(listClasse, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Classe> findById(@PathVariable Long id) {
        Optional<Classe> ecole = classeService.getClasse(id);
        if (!ecole.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(ecole.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/update/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id, @Valid @RequestBody Classe classe) {
        if (!classeService.getClasse(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(classeService.editClasse(classe));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!classeService.getClasse(id).isPresent()) {
            return "id not found";
        }
        classeService.deleteClasseById(id);
        return "Delete OK";
    }
    
    @GetMapping("/moyenneClasse/{id}")
    public ResponseEntity<Double> calculMoyenne(@PathVariable Long id) {
        Optional<Classe> classe = classeService.getClasse(id);
        if (!classe.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>( ServiceHelper.getInstance().calculMoyenneDeClasse(classe.get()), HttpStatus.OK);
    }

}
