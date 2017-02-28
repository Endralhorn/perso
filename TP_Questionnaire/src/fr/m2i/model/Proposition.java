package fr.m2i.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proposition")
public class Proposition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proposition")
	private int idProposition;
	
	@Column(name="texte_proposition")
	private String texteProposition;
	
	@ManyToOne
	@JoinColumn(name="id_question")
	private Question idQuestion;
	
	@ManyToMany(mappedBy="propositions")
	List<Cletest> candidatsTests;


	public int getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public String getTexteProposition() {
		return texteProposition;
	}

	public void setTexteProposition(String texteProposition) {
		this.texteProposition = texteProposition;
	}

	public Question getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Question idQuestion) {
		this.idQuestion = idQuestion;
	}
	

}
