/**
 * 
 */
package org.mino.project.etudiant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.mino.project.ecole.Ecole;
import org.mino.project.note.Note;
import org.mino.project.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author OneLogic
 *
 */
@Service
public class EtudiantService {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Optional<Etudiant> getEtudiant(Long id) {
        return etudiantRepository.findById(id);
    }
    
    public Etudiant editEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    
	public List<Etudiant> findEtudiantByPage(int pageNumber, int pageSize) {
        return etudiantRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
	
	public List<Etudiant> findAllEtudiant() {
        return etudiantRepository.findAll();
    }

    public void deleteEtudiantById(Long id) {
    	etudiantRepository.deleteById(id);
    }
    
    public void deleteEtudiant(Etudiant etudiant) {
    	etudiantRepository.delete(etudiant);
    }

}
