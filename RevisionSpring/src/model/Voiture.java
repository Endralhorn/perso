package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="voiture")
public class Voiture implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	
	@Column(name="Voiture_ID")
	private String ID;
	
	@Column(name="Voiture_marque")
	private String marque;

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Voiture() {
		super();
	}

	public Voiture(String marque) {
		super();
		this.marque = marque;
	}

	@Override
	public String toString() {
		
		String stringvoiture = this.marque ;
		return stringvoiture;
		
		
	}
	
	

}
