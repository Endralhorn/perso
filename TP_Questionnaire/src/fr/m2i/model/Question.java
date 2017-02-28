package fr.m2i.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_question")
	private int idQuestion;
	
	@Column(name="texte_question")
	private String texteQuestion;
	
	@Column(name="id_reponse_correct")
	private Proposition bonneReponse;
	
	@ManyToOne
	@JoinColumn(name="idQuestionnaire")
	private Questionnaire idQuestionnaire;
	
	@OneToMany(mappedBy="idQuestion", fetch=FetchType.EAGER)
	private List<Proposition> propositions;
	

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		
//		UUID.randomUUID().toString().substring(6);
		
		this.idQuestion = idQuestion;
	}

	public String getTexteQuestion() {
		return texteQuestion;
	}

	public void setTexteQuestion(String texteQuestion) {
		this.texteQuestion = texteQuestion;
	}

	public Questionnaire getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(Questionnaire idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Proposition getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(Proposition bonneReponse) {
		this.bonneReponse = bonneReponse;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	
	

}
