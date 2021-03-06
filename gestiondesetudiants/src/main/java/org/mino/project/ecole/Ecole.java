package org.mino.project.ecole;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.mino.project.Helper.ServiceHelper;
import org.mino.project.classe.Classe;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ecole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcole; 
	private String nomEcole;
	
	@OneToMany(mappedBy="ecole", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval=true)
	@JsonIgnore
	private List<Classe> listClasse;
	
	private Double moyenneEcole;
	/**
	 * @return the idEcole
	 */
	public Long getIdEcole() {
		return idEcole;
	}
	/**
	 * @param idEcole the idEcole to set
	 */
	public void setIdEcole(Long idEcole) {
		this.idEcole = idEcole;
	}
	/**
	 * @return the nomEcole
	 */
	public String getNomEcole() {
		return nomEcole;
	}
	/**
	 * @param nomEcole the nomEcole to set
	 */
	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}
	/**
	 * @return the listClasse
	 */
	public List<Classe> getListClasse() {
		return listClasse;
	}
	/**
	 * @param listClasse the listClasse to set
	 */
	public void setListClasse(List<Classe> listClasse) {
		this.getListClasse().clear();
		this.getListClasse().addAll(listClasse);
	}
	/**
	 * @return the moyenneEcole
	 */
	public Double getMoyenneEcole() {
		return ServiceHelper.getInstance().calculMoyenneEcole(this);
	}
	/**
	 * @param moyenneEcole the moyenneEcole to set
	 */
	public void setMoyenneEcole(Double moyenneEcole) {
		this.moyenneEcole = moyenneEcole;
	}

}
