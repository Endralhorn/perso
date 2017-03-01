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
	private IDAO<Question, Integer> qusetionDAO;
	
	@Autowired
	private IDAO<Proposition, Integer> propositionDAO;

	public IDAO<Question, Integer> getQusetionDAO() {
		return qusetionDAO;
	}

	public void setQusetionDAO(IDAO<Question, Integer> qusetionDAO) {
		this.qusetionDAO = qusetionDAO;
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
		List<Question> myQuestion = this.qusetionDAO.findAll();
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
			myQuestion = (Question)this.qusetionDAO.find(questionId); 
			
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
	public String editTestPost(@RequestParam(value="test_id", required=false) Integer testId,
									@RequestParam String testNom,
								Model model, 
								HttpSession session) {
		Test myTest = (Test) this.testDAO.find(testId);
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myTest == null)
		{
			myTest = new Test();
		}
		
		
		myTest.setNomTest(testNom);
		
		
		this.testDAO.save(myTest);
		return "redirect:/tests";
		
	}
		
	
	@RequestMapping(value = "/propositions", method=RequestMethod.GET)
	public String propositions(Model model, 
			HttpSession session) {
		List<Test> myTest = this.testDAO.findAll();
		model.addAttribute("tests", myTest);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de tests");
			
	return "tests";
	}
	
	@RequestMapping(value = "/editPropositions", method=RequestMethod.GET)
	public String editPropositionsGet(@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
										@RequestParam(value="test_id", required=false) Integer testId,
								Model model, 
								HttpSession session) {
		Questionnaire myQuestionnaire = null;

		if (questionnaireId != null)
		{

			myQuestionnaire = (Questionnaire)this.questionnaireDAO.find(questionnaireId); 
			model.addAttribute("questionnaire", myQuestionnaire);
			model.addAttribute("title", "Edition Questionnaire");

		}
			
		model.addAttribute("test", this.testDAO.find(testId));
		return "editQuestionnaire";
		
	}
	
	
	@RequestMapping(value = "/editPropositions", method=RequestMethod.POST)
	public String editPropositionsPost(@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
										@RequestParam(value="test_id", required=false) Integer testId,
										@RequestParam(value="questionnaire_nom", required=false) String questinnaireNom,
								Model model, 
								HttpSession session) {
		Test myTest = (Test) this.testDAO.find(testId);
		Questionnaire myQuestionnaire = (questionnaireId != null) ? (Questionnaire)this.questionnaireDAO.find(questionnaireId) : null;
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myQuestionnaire == null)
		{
			myQuestionnaire = new Questionnaire();
		}
		
		
		myQuestionnaire.setNomQuestionnaire(questinnaireNom);
		myTest.addQuestionnaire(myQuestionnaire);
		this.questionnaireDAO.save(myQuestionnaire);
		this.testDAO.save(myTest);
		
		List<Questionnaire> questionnaires = myTest.getQuestionnaires();
		session.setAttribute("questionnaires", questionnaires);
		
		
		return "editTest";
		
	}

	
}
