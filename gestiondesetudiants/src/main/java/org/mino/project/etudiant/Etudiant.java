package org.mino.project.etudiant;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.mino.project.Helper.ServiceHelper;
import org.mino.project.classe.Classe;
import org.mino.project.ecole.Ecole;
import org.mino.project.note.Note;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private Date dateNaissance;
	private Double moyenneEtudiant;
	
	@ManyToOne
	@JoinColumn(name="idClasse")
	private Classe classe;
	
	@OneToMany(mappedBy="etudiant", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Note> listNote;
	/**
	 * @return the idEtudiant
	 */
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	/**
	 * @param idEtudiant the idEtudiant to set
	 */
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	/**
	 * @return the nomEtudiant
	 */
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	/**
	 * @param nomEtudiant the nomEtudiant to set
	 */
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	/**
	 * @return the prenomEtudiant
	 */
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	/**
	 * @param prenomEtudiant the prenomEtudiant to set
	 */
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}
	/**
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	/**
	 * @return the listNote
	 */
	public List<Note> getListNote() {
		return listNote;
	}
	/**
	 * @param listNote the listNote to set
	 */
	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}
	/**
	 * @return the moyenneEtudiant
	 */
	public Double getMoyenneEtudiant() {
		return ServiceHelper.getInstance().calculMoyenneEtudiant(this);
	}
	/**
	 * @param moyenneEtudiant the moyenneEtudiant to set
	 */
	public void setMoyenneEtudiant(Double moyenneEtudiant) {
		this.moyenneEtudiant = moyenneEtudiant;
	}
	
}
