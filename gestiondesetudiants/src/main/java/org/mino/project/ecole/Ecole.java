package org.mino.project.ecole;

import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Ecole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcole; 
	private String nomEcole;
	
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

	public String toString() {
    	return "{idEcole:" + this.idEcole + ", nomEcole:" + this.nomEcole + "}";
    }
}
