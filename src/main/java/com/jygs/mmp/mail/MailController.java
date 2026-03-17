package com.jygs.mmp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jygs.mmp.login.LoginEntity;
import com.jygs.mmp.login.LoginRepository;
import com.jygs.mmp.login.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final LoginRepository lr;
	private final MailService ms;
	private final LoginService ls;
	
	@Autowired
	private PasswordEncoder pe;

    
	@RequestMapping(value="/emailCheck", method={RequestMethod.GET, RequestMethod.POST})
	public String emailCheck(MailDTO mDTO, HttpSession session)  throws Exception{
		
		int number = ms.sendMail(mDTO.getEmail());
		session.setAttribute("emailCode", number);
		
		String encodedPass = pe.encode(mDTO.getPass());

	    session.setAttribute("email", mDTO.getEmail());
	    session.setAttribute("password", encodedPass);
	    session.setAttribute("name", mDTO.getName());
		
		return "emailCheck";
	}

	// 인증번호 일치여부 확인
	@RequestMapping(value="/mailCheck", method={RequestMethod.GET, RequestMethod.POST})
    public String mailCheck(@RequestParam String userNumber, HttpSession session) {

		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
    	String html = "redirect:/emailCheck?email="+email+"&fail=1";
    	
    	int code = (int) session.getAttribute("emailCode");
        boolean isMatch = userNumber.equals(String.valueOf(code));
        
        if (isMatch) {
        	html="redirect:/?join=1";
            
            
            LoginEntity le = new LoginEntity();
            
            le.setEmail(email);
            le.setName(name);
            le.setPass(password);
            lr.save(le);
            
        }

        return html;
    }	
}
