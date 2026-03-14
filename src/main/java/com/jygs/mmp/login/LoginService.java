package com.jygs.mmp.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository lr;
	
	public LoginEntity searchOneUser(String email){
		Optional<LoginEntity> user = lr.findByEmail(email);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	public LoginEntity searchOneUser(String email, String pass){
		Optional<LoginEntity> user = lr.findByEmailAndPass(email,pass);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	
}
