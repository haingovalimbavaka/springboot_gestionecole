/**
 * 
 */
package org.mino.project.note;

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
@RequestMapping("/api/notes")
public class NoteAPI {
	
	@Autowired
	private NoteService noteService;
		
    @PostMapping("/create")
    public String create(@Valid @RequestBody Note note) {
    	noteService.createNote(note);
        return "Ajout OK";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Note>> getAll() {
        List<Note> listNote = noteService.findAllNote();
        if (listNote.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(listNote, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNote(id);
        if (!note.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(note.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/update/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id, @Valid @RequestBody Note note) {
        if (!noteService.getNote(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(noteService.editNote(note));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!noteService.getNote(id).isPresent()) {
            return "id not found";
        }
        noteService.deleteNoteById(id);
        return "Delete OK";
    }

}
