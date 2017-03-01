package fr.m2i.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home(Model model, 
						HttpSession session) {
		if (session.getAttribute("administrateur") != null) {
			return "home";
		}
		
		return "redirect:/account/login";
		}


}
