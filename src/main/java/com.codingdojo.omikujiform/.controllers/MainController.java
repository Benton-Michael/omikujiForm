package com.codingdojo.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	// root route that redirects to index.jsp
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	// Make a request mapping for the url /omikuji 
	// to render the main page showing the Omikuji form.
	@GetMapping("/omikuji")
	public String omikuji() {
		return "index.jsp";
	}
	
	@GetMapping("/omikuji/show") 
	public String show(HttpSession session, Model model) {
		
		String result = (String) session.getAttribute("resultOmikuji");
		model.addAttribute("result", result);
		
		return "showOmikuji.jsp";
	}
	
	// sent in body not url
	@PostMapping("/processFormData")
	public String process(
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing,
			@RequestParam("message") String message,
			// inject session into our method
			HttpSession session
			) {
		String resultOmikuji = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, hobby, livingThing, message);
				
		// do stuff here
		session.setAttribute("resultOmikuji", resultOmikuji);
		
		return "redirect:/omikuji/show";
	}
	
	
}
