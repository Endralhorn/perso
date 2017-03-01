package fr.m2i.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.m2i.DAO.IAdministrateurDAO;
import fr.m2i.model.Administrateur;
import fr.m2i.validation.WrongUsernameOrPasswordException;



@Controller
@RequestMapping(value ="/account")
public class AccountController {
	
	@Autowired
	private IAdministrateurDAO adminDAO;
	
	
//	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
//	public String subscribe() {
//	return"subscribe";
//	}
//
//	
//	@RequestMapping(value ="/subscribe", method = RequestMethod.POST)
//	public String subscribe(@Valid @ModelAttribute("inscription") InscriptionUtilisateur inscriptionUtilisateur, BindingResult result, Model model) {
//		new PasswordCheckValidator().validate(inscriptionUtilisateur, result);
//	
//	if (result.hasErrors()) {
//		Administrateur myAdministrateur = new Administrateur();
//
//
//		inscriptionUtilisateur.setProperties(myAdministrateur);
//		this.adminDAO.save(myAdministrateur);
//		return "redirect:/home";
//	}
//	
//	return "subscribe";
//	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String username,
						@RequestParam String password,
						HttpSession session) {
		Administrateur myAdministrateur = null;
		
		try {
			myAdministrateur = this.adminDAO.auth(username, password);
		} catch (WrongUsernameOrPasswordException e) {
			// TODO Auto-generated catch block
			e.rejectValue("userPass", "pwdcheck", "Les mots de passe ne correspondent pas.");
		}
		
		if (myAdministrateur != null) {
			session.setAttribute("administrateur", myAdministrateur);
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
			
		return "login";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logout(HttpSession session,
						Model model) {
		session.invalidate();
		return "login";
	}
	
	
	@ModelAttribute("user")
	public Administrateur initAdmin() {
	Administrateur myAdministrateur = new Administrateur();
	return myAdministrateur;
		
		}
	
}
