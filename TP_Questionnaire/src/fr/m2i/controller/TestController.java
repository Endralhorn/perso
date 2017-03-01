package fr.m2i.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ascadis.model.Bloc;
import fr.ascadis.model.Tetrimino;
import fr.m2i.DAO.IDAO;
import fr.m2i.DAO.TestDAO;
import fr.m2i.model.Test;

@Controller
public class TestController {
	
	@Autowired
	private IDAO<Test, Integer> testDAO;

	public IDAO<Test, Integer> getTestDAO() {
		return testDAO;
	}

	public void setTestDAO(IDAO<Test, Integer> testDAO) {
		this.testDAO = testDAO;
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
	public String editTetriminoGet(@RequestParam(value="test_id", required=false) int test_id,
								Model model, 
								HttpSession session) {
		Test myTest = 
//		String myTitre;

		if (myTest == null)
		{this.testDAO.find(test_id);
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myTest = new Test(); 
			
			if (myTest == null)
			{
				
				return "redirect:/home";
			}
			
			model.addAttribute("title", "Edition Tetrimino");
//			myTitre = "Edition Tetrimino";
		}
		
		else
		{
			myTetrimino = new Test("Pas de nom", "000");
			model.addAttribute("title", "Nouveau tetrimino");
//			myTitre = "Nouveau tetrimino";
		}
		
		session.setAttribute("tetrimino", myTetrimino);
		List<Bloc> blocs = myTetrimino.getBlocs();
		session.setAttribute("blocs", blocs);
		return "editTetrimino";
		
	}
	
	
	@RequestMapping(value = "/editTetrimino", method=RequestMethod.GET)
	public String editTetriminoGet(@RequestParam(value="tetrimino_id", required=false) String tetri_id,
								Model model, 
								HttpSession session) {
		Tetrimino myTetrimino = null;
//		String myTitre;

		if (tetri_id != null)
		{
//			String myTetriminoId = req.getParameter("tetrimino_id");
			myTetrimino = (Tetrimino) this.tetriminoHibernateDAO.find(tetri_id);
			
			if (myTetrimino == null)
			{
				
				return "redirect:/home";
			}
			
			model.addAttribute("title", "Edition Tetrimino");
//			myTitre = "Edition Tetrimino";
		}
		
		else
		{
			myTetrimino = new Tetrimino("Pas de nom", "000");
			model.addAttribute("title", "Nouveau tetrimino");
//			myTitre = "Nouveau tetrimino";
		}
		
		session.setAttribute("tetrimino", myTetrimino);
		List<Bloc> blocs = myTetrimino.getBlocs();
		session.setAttribute("blocs", blocs);
		return "editTetrimino";
		
	}
	
}
