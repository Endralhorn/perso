package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.DAOVoiture;
import model.Voiture;

@Controller
public class controller {
	
	@Autowired
	private DAOVoiture voitureDAO;
	
	@RequestMapping("/voitures")
	public String voitures (Model model ){
		List<Voiture> listevoiture=this.voitureDAO.findAll();
		
		model.addAttribute("listvoiture", listevoiture );
		
		
		
		return "voitures";
		
	}

}
