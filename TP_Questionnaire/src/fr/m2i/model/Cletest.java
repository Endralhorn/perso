package fr.m2i.model;

import java.io.Serializable;

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
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	
	@Column(name = "cle_unique")
	@Size(max=6)
	private String cleunique;

	@Column(name = "id_test")
	private int idtest;
	
	@Column(name = "id_candidat")
	private String candidat;

}
