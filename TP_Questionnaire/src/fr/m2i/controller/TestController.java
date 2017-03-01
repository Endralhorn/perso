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
		List<Test> myTest = this.testDAO.findAll();
		model.addAttribute("tests", myTest);
		model.addAttribute("montrerActions","true");
		model.addAttribute("title", "Liste de tests");
			
	return "tests";
	}
	
	
	@RequestMapping(value = "/editTest", method=RequestMethod.GET)
	public String editTestGet(@RequestParam(value="test_id", required=false) Integer test_id,
								Model model, 
								HttpSession session) {
		Test myTest = null;
//		String myTitre;

		if (test_id != null)
		{
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myTest = (Test)this.testDAO.find(test_id); 
			
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
	public String editTestPost(@RequestParam(value="test_id", required=false) Integer test_id,
									@RequestParam String test_nom,
								Model model, 
								HttpSession session) {
		Test myTest = (Test) this.testDAO.find(test_id);
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myTest == null)
		{
			myTest = new Test();
		}
		
		
		myTest.setNomTest(test_nom);
		
		
		this.testDAO.save(myTest);
		return "redirect:/tests";
		
	}
		
	
	@RequestMapping(value = "/editQuestionnaire", method=RequestMethod.GET)
	public String editQuestionnaireGet(@RequestParam(value="questionnaire_id", required=false) Integer questionnaire_id,
								Model model, 
								HttpSession session) {
		Questionnaire myQuestionnaire = null;
//		String myTitre;

		if (questionnaire_id != null)
		{
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myQuestionnaire = (Questionnaire)this.questionnaireDAO.find(questionnaire_id); 
			
			if (myQuestionnaire == null)
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
	
	
	@RequestMapping(value = "/editQuestionnaire", method=RequestMethod.POST)
	public String editQuestionnairePost(@RequestParam(value="test_id", required=false) Integer test_id,
									@RequestParam String test_nom,
								Model model, 
								HttpSession session) {
		Test myTest = (Test) this.testDAO.find(test_id);
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myTest == null)
		{
			myTest = new Test();
		}
		
		
		myTest.setNomTest(test_nom);
		
		
		this.testDAO.save(myTest);
		return "redirect:/tests";
		
	}

	
	
}
