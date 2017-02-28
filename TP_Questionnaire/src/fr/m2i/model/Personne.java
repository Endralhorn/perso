package fr.m2i.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="personne")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")

public class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_test")
	private int id;
	
	@Column (name="nom_personne")
	private String nom;
	
	@Column (name="prenom_personne")
	private String prenom;
	
	@Column (name="age_personne")
	private int age;
	
	@Column (name="type_personne")
	private String type;

}
