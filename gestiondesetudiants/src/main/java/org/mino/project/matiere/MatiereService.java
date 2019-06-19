package org.mino.project.matiere;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MatiereService {
	
	@Autowired
	private MatiereRepository matiereRepository;

    public Matiere createMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public Optional<Matiere> getMatiere(Long id) {
        return matiereRepository.findById(id);
    }
    
    public Matiere editMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }
    
	public List<Matiere> findMatiereByPage(int pageNumber, int pageSize) {
        return matiereRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
	
	public List<Matiere> findAllMatiere() {
        return matiereRepository.findAll();
    }

    public void deleteMatiereById(Long id) {
    	matiereRepository.deleteById(id);
    }
    
    public void deleteMatiere(Matiere matiere) {
    	matiereRepository.delete(matiere);
    }
}
