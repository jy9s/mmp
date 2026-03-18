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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final LoginRepository lr;
	private final MailService ms;
	
	@Autowired
	private PasswordEncoder pe;

    
	@RequestMapping(value={"/emailCheck", "/searchProcess"}, method={RequestMethod.GET, RequestMethod.POST})
	public String emailCheck(@RequestParam("type") String type,MailDTO mDTO, HttpSession session)  throws Exception{
		
		int number = ms.sendMail(mDTO.getEmail());
		session.setAttribute("emailCode", number);
		
		String encodedPass = pe.encode(mDTO.getPass());

	    session.setAttribute("email", mDTO.getEmail());
	    session.setAttribute("password", encodedPass);
	    session.setAttribute("name", mDTO.getName());
	    session.setAttribute("type", type);
	    return "emailCheck";
		
	}


	// 인증번호 일치여부 확인
	@Transactional
	@RequestMapping(value="/mailCheck", method={RequestMethod.GET, RequestMethod.POST})
    public String mailCheck(@RequestParam(defaultValue = "0") String userNumber, @RequestParam(defaultValue = "0") String change, @RequestParam(defaultValue = "0") String changePass,  HttpSession session) {

		String type = (String) session.getAttribute("type");
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
    	String html = "redirect:/emailCheck?email="+email+"&fail=1";
    	
    	LoginEntity le = new LoginEntity();
    	
    	
    	
    	int code = (int) session.getAttribute("emailCode");
        boolean isMatch = userNumber.equals(String.valueOf(code));
        
        if (isMatch && "signup".equals(type)) {
        	
            le.setEmail(email);
            le.setName(name);
            le.setPass(password);
            lr.save(le);
            
            html="redirect:/?join=1";
            
        }else if(isMatch && "find".equals(type)) {
        	        	
        	html="redirect:changePass?email="+email;
        	
        }else if("changePass".equals(change)) {
        	String encodedPass = pe.encode(changePass);
        	le = lr.findByEmail(email).orElseThrow(() -> new RuntimeException(""));
        	le.setPass(encodedPass);        	
        	html="redirect:/?join=1";
        }
        
        
        
        return html;
    }	
}
