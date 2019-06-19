/**
 * 
 */
package org.mino.project.note;

import java.util.List;
import java.util.Optional;

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

}
