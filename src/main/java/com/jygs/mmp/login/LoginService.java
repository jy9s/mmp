package com.jygs.mmp.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository lr;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	public LoginEntity searchOneUser(String email){
		Optional<LoginEntity> user = lr.findByEmail(email.trim());
		
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	
	
	public LoginEntity searchOneUser(String email, String pass){
		Optional<LoginEntity> user = lr.findByEmail(email.trim());
				
		if(user.isPresent()) {
			
			if(pe.matches(pass, user.get().getPass())) {				
				return user.get();				
			}
			
			
		}
		
		return null;
	}
	
	
}
