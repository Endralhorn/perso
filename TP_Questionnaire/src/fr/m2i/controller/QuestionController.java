package fr.m2i.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.m2i.DAO.IDAO;
import fr.m2i.model.Proposition;
import fr.m2i.model.Question;
import fr.m2i.model.Questionnaire;
import fr.m2i.model.Test;



@Controller
public class QuestionController {
	
	@Autowired
	private IDAO<Question, Integer> questionDAO;
	
	@Autowired
	private IDAO<Proposition, Integer> propositionDAO;
	
	@Autowired
	private IDAO<Questionnaire, Integer> questionnaireDAO;
	

	public IDAO<Question, Integer> getQusetionDAO() {
		return questionDAO;
	}

	public void setQusetionDAO(IDAO<Question, Integer> questionDAO) {
		this.questionDAO = questionDAO;
	}

	public IDAO<Proposition, Integer> getPropositionDAO() {
		return propositionDAO;
	}

	public void setPropositionDAO(IDAO<Proposition, Integer> propositionDAO) {
		this.propositionDAO = propositionDAO;
	}
	
	
	
	@RequestMapping(value = "/questions", method=RequestMethod.GET)
	public String questions(Model model, 
							HttpSession session) {
		List<Question> myQuestion = this.questionDAO.findAll();
		model.addAttribute("questions", myQuestion);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de questions");
			
	return "questions";
	}
	
	
	@RequestMapping(value = "/editQuestion", method=RequestMethod.GET)
	public String editQuestionGet(@RequestParam(value="question_id", required=false) Integer questionId,
								Model model, 
								HttpSession session) {
		Question myQuestion = null;

		if (questionId != null)
		{
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myQuestion = (Question)this.questionDAO.find(questionId); 
			
			if (myQuestion == null)
			{
				
				return "redirect:/questionnaire";
			}
			
			model.addAttribute("title", "Edition Question");
//			myTitre = "Edition Tetrimino";
		}
		
		else
		{
			myQuestion = new Question("Pas de nom");
			model.addAttribute("title", "Nouvelle question");
//			myTitre = "Nouveau tetrimino";
		}
		
		session.setAttribute("question", myQuestion);
		List<Proposition> propositions = myQuestion.getPropositions();
		session.setAttribute("propositions", propositions);
		return "editQuestion";
		
	}
	
	
	
	
	@RequestMapping(value = "/editQuestion", method=RequestMethod.POST)
	public String editQuestionPost(@RequestParam(value="question_id", required=false) Integer questionId,
									@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
									@RequestParam(value="texte_question", required=false) String texteQuestion,
								Model model, 
								HttpSession session) {
		Questionnaire myQuestionnaire = (Questionnaire) this.questionnaireDAO.find(questionnaireId);
		Question myQuestion = (Question) this.questionDAO.find(questionId);
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myQuestion == null)
		{
			myQuestion = new Question();
		}
		
		
		myQuestion.setTexteQuestion(texteQuestion);
		myQuestionnaire.addQuestion(myQuestion);
		this.questionDAO.save(myQuestion);
		this.questionnaireDAO.save(myQuestionnaire);
		
		List<Question> questions = myQuestionnaire.getQuestions();
		session.setAttribute("questions", questions);
		
		return "redirect:/questions";
		
	}
	
	@RequestMapping(value = "/deleteQuestion", method=RequestMethod.GET)
	public String deleteQuestionGet(@RequestParam(value="question_id", required=false) Integer questionId,
										@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
										Model model, 
										HttpSession session) {
		try
		{
			
			this.questionDAO.delete(this.questionDAO.find(questionId));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Questionnaire myQuestionnaire = (Questionnaire) this.questionnaireDAO.find(questionnaireId);
		
		List<Question> questions = myQuestionnaire.getQuestions();
		session.setAttribute("questions", questions);
		
		return "questions";
		
	}
		
	
	@RequestMapping(value = "/propositions", method=RequestMethod.GET)
	public String propositions(Model model, 
								HttpSession session) {
		List<Proposition> myPropositions = this.propositionDAO.findAll();
		model.addAttribute("propositions", myPropositions);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de Propositions");
			
	return "editQuestion";
	}
	
	@RequestMapping(value = "/editPropositions", method=RequestMethod.GET)
	public String editPropositionsGet(@RequestParam(value="proposition_id", required=false) Integer propositionId,
										@RequestParam(value="question_id", required=false) Integer questionId,
										Model model, 
										HttpSession session) {
		Proposition myProposition = null;

		if (propositionId != null)
		{

			myProposition = (Proposition)this.propositionDAO.find(propositionId); 
			model.addAttribute("proposition", myProposition);
			model.addAttribute("title", "Edition Proposition");

		}
			
		model.addAttribute("question", this.questionDAO.find(questionId));
		return "editQuestion";
		
	}
	
	
	@RequestMapping(value = "/editPropositions", method=RequestMethod.POST)
	public String editPropositionsPost(@RequestParam(value="proposition_id", required=false) Integer propositionId,
										@RequestParam(value="question_id", required=false) Integer questionId,
										@RequestParam(value="proposition_nom", required=false) String propositionNom,
										Model model, 
										HttpSession session) {
		Question myQuestion = (Question) this.questionDAO.find(questionId);
		Proposition myProposition = (propositionId != null) ? (Proposition)this.propositionDAO.find(propositionId) : null;
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myProposition == null)
		{
			myProposition = new Proposition();
		}
		
		
		myProposition.setTexteProposition(propositionNom);
		myQuestion.addProposition(myProposition);
		this.propositionDAO.save(myProposition);
		this.questionDAO.save(myQuestion);
		
		List<Proposition> propositions = myQuestion.getPropositions();
		session.setAttribute("propositions", propositions);
		
		
		return "editQuestion";
		
	}
	
	@RequestMapping(value = "/deleteProposition", method=RequestMethod.GET)
	public String deletePropositionGet(@RequestParam(value="propositions_id", required=false) Integer propositionsId,
										@RequestParam(value="question_id", required=false) Integer questionId,
										Model model, 
										HttpSession session) {
		try
		{
			
			this.propositionDAO.delete(this.propositionDAO.find(propositionsId));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Question myQuestion = (Question) this.questionDAO.find(questionId);
		
		List<Proposition> propositions = myQuestion.getPropositions();
		session.setAttribute("propositions", propositions);
		
		return "editQuestion";
		
	}

	
}
