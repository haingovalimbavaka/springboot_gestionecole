package org.mino.project.ecole;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class EcoleService{
	@Autowired
	private EcoleRepository ecoleRepository;
	
    public Ecole createEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    public Optional<Ecole> getEcole(Long id) {
        return ecoleRepository.findById(id);
    }
    
    public Ecole editEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }
    
	public List<Ecole> findEcolesByPage(int pageNumber, int pageSize) {
        return ecoleRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
	
	public List<Ecole> findAllEcole() {
        return ecoleRepository.findAll();
    }

    public void deleteEcoleById(Long id) {
    	ecoleRepository.deleteById(id);
    }
    
    public void deleteEcole(Ecole ecole) {
    	ecoleRepository.delete(ecole);
    }

}
