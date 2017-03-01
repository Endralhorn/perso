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
import fr.m2i.model.Questionnaire;
import fr.m2i.model.Test;

@Controller
public class TestController {
	
	@Autowired
	private IDAO<Test, Integer> testDAO;
	
	@Autowired
	private IDAO<Questionnaire, Integer> questionnaireDAO;

	public IDAO<Test, Integer> getTestDAO() {
		return testDAO;
	}

	public void setTestDAO(IDAO<Test, Integer> testDAO) {
		this.testDAO = testDAO;
	}
	
	public IDAO<Questionnaire, Integer> getQuestionnaireDAO() {
		return questionnaireDAO;
	}

	public void setQuestionnaireDAO(IDAO<Questionnaire, Integer> questionnaireDAO) {
		this.questionnaireDAO = questionnaireDAO;
	}
		

	@RequestMapping(value = "/tests", method=RequestMethod.GET)
	public String tests(Model model, 
			HttpSession session) {
		List<Test> myTests = this.testDAO.findAll();
		model.addAttribute("tests", myTests);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de tests");
			
	return "tests";
	}
	
	
	@RequestMapping(value = "/editTest", method=RequestMethod.GET)
	public String editTestGet(@RequestParam(value="test_id", required=false) Integer testId,
								Model model, 
								HttpSession session) {
		Test myTest = null;
//		String myTitre;

		if (testId != null)
		{
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myTest = (Test)this.testDAO.find(testId); 
			
			if (myTest == null)
			{
				
				return "redirect:/home";
			}
			
			model.addAttribute("title", "Edition Test");
//			myTitre = "Edition Tetrimino";
		}
		
		else
		{
			myTest = new Test("Pas de nom");
			model.addAttribute("title", "Nouveau test");
//			myTitre = "Nouveau tetrimino";
		}
		
		session.setAttribute("test", myTest);
		List<Questionnaire> questionnaires = myTest.getQuestionnaires();
		session.setAttribute("questionnaires", questionnaires);
		return "editTest";
		
	}
	
	
	@RequestMapping(value = "/editTest", method=RequestMethod.POST)
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
		
	
	@RequestMapping(value = "/questionnaires", method=RequestMethod.GET)
	public String questionnaires(Model model, 
								HttpSession session) {
		List<Questionnaire> myQuestionnaires = this.questionnaireDAO.findAll();
		model.addAttribute("questionnaires", myQuestionnaires);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de questionnaires");
			
	return "editTest";
	}
	
	
	@RequestMapping(value = "/editQuestionnaire", method=RequestMethod.GET)
	public String editQuestionnaireGet(@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
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
	
	
	@RequestMapping(value = "/editQuestionnaire", method=RequestMethod.POST)
	public String editQuestionnairePost(@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
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

	@RequestMapping(value = "/deleteQuestionnaire", method=RequestMethod.GET)
	public String deleteQuestionnaireGet(@RequestParam(value="questionnaire_id", required=false) Integer questionnaireId,
										@RequestParam(value="test_id", required=false) Integer testId,
										Model model, 
										HttpSession session) {
		try
		{
			
			this.questionnaireDAO.delete(this.questionnaireDAO.find(questionnaireId));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Test myTest = (Test) this.testDAO.find(testId);
		
		List<Questionnaire> questionnaires = myTest.getQuestionnaires();
		session.setAttribute("questionnaires", questionnaires);
		
		return "editTest";
		
	}
	
}
