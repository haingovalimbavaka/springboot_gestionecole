package org.mino.project.classe;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.mino.project.ecole.Ecole;
import org.mino.project.etudiant.Etudiant;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasse;
	private String libelleClasse;
	
	@ManyToOne
	@JoinColumn(name="idEcole")
	private Ecole ecole;
	
	@OneToMany(mappedBy="classe", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Etudiant> listEtudiant;
	/**
	 * @return the libelleClasse
	 */
	public String getLibelleClasse() {
		return libelleClasse;
	}
	/**
	 * @param libelleClasse the libelleClasse to set
	 */
	public void setLibelleClasse(String libelleClasse) {
		this.libelleClasse = libelleClasse;
	}
	/**
	 * @return the idClasse
	 */
	public Long getIdClasse() {
		return idClasse;
	}
	/**
	 * @param idClasse the idClasse to set
	 */
	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}
	/**
	 * @return the ecole
	 */
	public Ecole getEcole() {
		return ecole;
	}
	/**
	 * @param ecole the ecole to set
	 */
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	/**
	 * @return the listEtudiant
	 */
	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
	}
	/**
	 * @param listEtudiant the listEtudiant to set
	 */
	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	
}
