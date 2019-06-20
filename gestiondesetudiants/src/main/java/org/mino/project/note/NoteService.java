/**
 * 
 */
package org.mino.project.note;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author OneLogic
 *
 */
@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getNote(Long id) {
        return noteRepository.findById(id);
    }
    
    public Note editNote(Note note) {
        return noteRepository.save(note);
    }
    
	public List<Note> findNoteByPage(int pageNumber, int pageSize) {
        return noteRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
	
	public List<Note> findAllNote() {
        return noteRepository.findAll();
    }

    public void deleteNoteById(Long id) {
    	noteRepository.deleteById(id);
    }
    
    public void deleteNote(Note note) {
    	noteRepository.delete(note);
    }
    
    /* get notes by etudiant */
    public List<Note> getNotesByEtudiant(Long idEtudiant) {    	
    	return noteRepository.findAll().stream().filter(note -> note.getEtudiant().getIdEtudiant() == idEtudiant).collect(Collectors.toList()); 
    }
        
    /* get notes by classe */
    public List<Note> getNotesByClasse(Long idClasse) {    	
    	return noteRepository.findAll().stream().filter(note -> note.getEtudiant().getClasse().getIdClasse() == idClasse).collect(Collectors.toList()); 
    }
    
    /* get notes by ecole */
    public List<Note> getNotesByEcole(Long idEcole) {    	
    	return noteRepository.findAll().stream().filter(note -> note.getEtudiant().getClasse().getEcole().getIdEcole() == idEcole).collect(Collectors.toList()); 
    }
}
