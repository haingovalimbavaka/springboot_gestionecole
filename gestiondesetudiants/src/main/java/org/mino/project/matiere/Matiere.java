package org.mino.project.matiere;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMatiere;
	private String refMatiere;
	/**
	 * @return the idMatiere
	 */
	public Long getIdMatiere() {
		return idMatiere;
	}
	/**
	 * @param idMatiere the idMatiere to set
	 */
	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}
	/**
	 * @return the refMatiere
	 */
	public String getRefMatiere() {
		return refMatiere;
	}
	/**
	 * @param refMatiere the refMatiere to set
	 */
	public void setRefMatiere(String refMatiere) {
		this.refMatiere = refMatiere;
	}
	
}
