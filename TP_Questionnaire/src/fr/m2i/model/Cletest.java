package fr.m2i.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cletest")
public class Cletest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cle_unique")
	
	private String cleUnique;
	
	

	
	
	

	@Column(name = "id_test")
	private int idTest;
	
	@Column(name = "id_candidat")
	private String idCandidat;
	
	
	
	
	


	public String getCleUnique() {
		return cleUnique;
	}

	public void setCleUnique(String cleUnique) {
		this.cleUnique = cleUnique;
		
		
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getIdCandidat() {
		return idCandidat;
	}

	public void setIdCandidat(String idCandidat) {
		this.idCandidat = idCandidat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cletest() {
		super();
		this.cleUnique = UUID.randomUUID().toString().substring(6) ;
	}
	
	
	

}
