package fr.m2i.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questionnaire")
public class Questionnaire {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_questionnaire")
	private int idQuestionnaire;
	
	@Column(name="nom_questionnaire")
	private String nomQuestionnaire;
	
	@OneToMany(mappedBy="idQuestionnaire", fetch=FetchType.EAGER)
	private List<Question> questions;
	
	@ManyToMany(mappedBy="questionnaires")
	List<Test> tests;

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public String getNomQuestionnaire() {
		return nomQuestionnaire;
	}

	public void setNomQuestionnaire(String nomQuestionnaire) {
		this.nomQuestionnaire = nomQuestionnaire;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question myQuestion) {
		this.questions.add(myQuestion);
	}

	public Questionnaire(String nomQuestionnaire) {
		super();
		this.nomQuestionnaire = nomQuestionnaire;
	}

	public Questionnaire() {
		super();
	}
	
	
	

}
