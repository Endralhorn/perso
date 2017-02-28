package fr.m2i.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


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
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)//(cascade=CascadeType.MERGE)
	@JoinTable(
		name="reponse_test",
		uniqueConstraints = @UniqueConstraint( columnNames = { "id_proposition_RT", "cle_unique" } ),
		joinColumns=@JoinColumn(name="cle_unique_RT", referencedColumnName="cle_unique"),
	    inverseJoinColumns=@JoinColumn(name="id_proposition_RT", referencedColumnName="id_proposition")
	)
	private List<Proposition> propositions;
	
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
