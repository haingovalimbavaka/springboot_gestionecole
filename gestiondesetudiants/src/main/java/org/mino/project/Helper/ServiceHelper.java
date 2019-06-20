package org.mino.project.Helper;

import java.util.stream.Collectors;

import org.mino.project.classe.Classe;
import org.mino.project.ecole.Ecole;
import org.mino.project.etudiant.Etudiant;

public class ServiceHelper {
	
	/** Constructeur privé */
	private ServiceHelper()
	{}
	
	private static ServiceHelper INSTANCE = new ServiceHelper();
	
	/** Point d'accès pour l'instance unique du singleton */
    public static ServiceHelper getInstance()
    {   return INSTANCE;
    }
    	    
    /* calcul moyenne etudiant */
    public double calculMoyenneEtudiant(Etudiant etudiant) { 
        double sum = etudiant.getListNote().stream().map(x -> x.getValeur()).collect(Collectors.summingDouble((Double::doubleValue)));
        if(!etudiant.getListNote().isEmpty())
        	return sum/etudiant.getListNote().size();
        else
        	return 0D;        	
    }
    
    /* calcul moyenne de classe */
    public double calculMoyenneDeClasse(Classe classe) {     	
    	double sum = classe.getListEtudiant().stream().map(etudiant -> etudiant.getMoyenneEtudiant()).collect(Collectors.summingDouble((Double::doubleValue)));
        if(!classe.getListEtudiant().isEmpty())
        	return sum/classe.getListEtudiant().size();
        else
        	return 0D;        	
    }
    
    /* calcul moyenne de l'ecole */
    public double calculMoyenneEcole(Ecole ecole) {     	
    	double sum = ecole.getListClasse().stream().map(classe -> classe.getMoyenneClasse()).collect(Collectors.summingDouble((Double::doubleValue)));
        if(!ecole.getListClasse().isEmpty())
        	return sum/ecole.getListClasse().size();
        else
        	return 0D;        	
    }
}
