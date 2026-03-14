package com.jygs.mmp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService ls;
	
	
	@GetMapping("/")
	public String login() {
		
		
		return "login";
	}
	
	
	@GetMapping("/searchPass")
	public String searchPass() {
		
		
		return "searchPass";
	}
	
	
	@PostMapping("/pass")
	public String pass(LoginEntity le, Model model) {
		
		
		LoginEntity user = ls.searchOneUser(le.getEmail());
		
		
		model.addAttribute("user",le);
		
		if(user==null) {
			
			return "register";
		}
		
		
		return "pass";
	}
	
	@GetMapping("/registerProcess")
	public String registerProcess(LoginEntity le, Model model) {

		LoginEntity user = ls.searchOneUser(le.getEmail());
		model.addAttribute("user",le);
		
		return "registerProcess";
	}

}
