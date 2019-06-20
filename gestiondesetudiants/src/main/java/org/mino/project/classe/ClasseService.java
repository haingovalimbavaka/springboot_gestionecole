package org.mino.project.classe;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mino.project.etudiant.Etudiant;
import org.mino.project.etudiant.EtudiantService;
import org.mino.project.note.Note;
import org.mino.project.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClasseService {	
	@Autowired
	private ClasseRepository classeRepository;
		
    public Classe createClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public Optional<Classe> getClasse(Long id) {
        return classeRepository.findById(id);
    }
    
    public Classe editClasse(Classe classe) {
        return classeRepository.save(classe);
    }
    
	public List<Classe> findClasseByPage(int pageNumber, int pageSize) {
        return classeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
	
	public List<Classe> findAllClasse() {
        return classeRepository.findAll();
    }

    public void deleteClasseById(Long id) {
    	classeRepository.deleteById(id);
    }
    
    public void deleteClasse(Classe classe) {
    	classeRepository.delete(classe);
    }


}
