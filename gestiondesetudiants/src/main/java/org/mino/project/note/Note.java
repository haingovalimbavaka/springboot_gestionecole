package org.mino.project.note;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.mino.project.etudiant.Etudiant;
import org.mino.project.matiere.Matiere;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNote;
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private Matiere matiere;
	private Double valeur;
	
	@ManyToOne
	@JoinColumn(name="idEtudiant")
	private Etudiant etudiant;
	
	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}
	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	/**
	 * @return the idNote
	 */
	public Long getIdNote() {
		return idNote;
	}
	/**
	 * @param idNote the idNote to set
	 */
	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}
	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}
	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	/**
	 * @return the valeur
	 */
	public Double getValeur() {
		return valeur;
	}
	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

}
