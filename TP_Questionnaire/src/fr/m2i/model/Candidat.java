package fr.m2i.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("candidat")

public class Candidat extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
