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
		
		//check email
		if(user==null) {
			
			return "register";
		}
		
		
		return "pass";
	}
	
	
	@GetMapping("/registerProcess")
	public String registerProcess(LoginEntity le, Model model) {

		model.addAttribute("user",le);
		
		return "registerProcess";
	}
	
	
	@PostMapping("/loginProcess")
	public String loginProcess(LoginEntity le, Model model) {

		
		LoginEntity user = ls.searchOneUser(le.getEmail(),le.getPass());
		//check account
		if(user==null) {
			
			model.addAttribute("user",le);
			model.addAttribute("flag",1);
			return "pass";
		}
		
		model.addAttribute("user",le);
		
		return "redirect:dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		
		
		return "dashboard";
	}

	
	@PostMapping("/emailCheck")
	public String emailCheck() {
		
		return "emailCheck";
		
	}

}
