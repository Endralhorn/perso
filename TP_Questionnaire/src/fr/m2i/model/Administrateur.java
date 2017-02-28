package fr.m2i.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrateur")

public class Administrateur extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
