package fr.m2i.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="test")
public class Test implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_test")
	private int id;
	
	@Column(name="nom_test")
	private String nomTest;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)//(cascade=CascadeType.MERGE)
	@JoinTable(
		name="test_QCM",
		uniqueConstraints = @UniqueConstraint( columnNames = { "id_questionnaire_TQ", "id_test_TQ" } ),
		joinColumns=@JoinColumn(name="id_test_TQ", referencedColumnName="id_test"),
	    inverseJoinColumns=@JoinColumn(name="id_questionnaire_TQ", referencedColumnName="id_questionnaire")
	)
	private List<Questionnaire> questionnaires;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomTest() {
		return nomTest;
	}

	public void setNomTest(String nomTest) {
		this.nomTest = nomTest;
	}
	
	

}
