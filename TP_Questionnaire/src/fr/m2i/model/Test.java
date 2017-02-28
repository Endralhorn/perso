package fr.m2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_test")
	private int id;
	
	@Column(name="nom_test")
	private String nomTest;

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
