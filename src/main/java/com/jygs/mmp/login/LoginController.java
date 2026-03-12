package com.jygs.mmp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String login() {
		
		
		return "login";
	}
	
	
	@GetMapping("/searchPass")
	public String searchPass() {
		
		
		return "searchPass";
	}
	
	@GetMapping("/register")
	public String register() {
		
		
		return "register";
	}
	@PostMapping("/pass")
	public String pass(LoginDTO lDTO) {
		
		System.out.println(lDTO.getId());
		
		return "pass";
	}

}
