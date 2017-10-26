package com.example.thymleaf;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private String message = "Hello World";
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", this.message);		
		return "home";
	}
	
	@PostMapping("/home")
	public String home(Model model,@RequestParam(value="email", required=true) String email,@RequestParam(value="password", required=true) String password) {
		model.addAttribute("message", this.message);
		model.addAttribute("email", email);
		logger.info("Email : "+email);
		logger.info("Password : "+password);
		return "home";
	}
	
	@PostMapping("/home/another")
	public String homeHttpServletRequest(Model model,HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		model.addAttribute("message", this.message);
		model.addAttribute("email", email);
		
		logger.info("Email : "+email);
		logger.info("Password : "+password);
		
		return "home";
	}
	
}
