package com.jygs.mmp.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "jyeppp@gmail.com";
    private int number;

	// 랜덤으로 숫자 생성
    public void createNumber() {
    	number = (int)(Math.random() * 900000) + 100000;
    }

    public MimeMessage createMail(String mail) {
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
        	message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
        	    MimeMessage.RecipientType.TO,
        	    InternetAddress.parse(mail)
        	);
            message.setSubject("メール認証コード");
            String body = "";
            body += "<h3>" + "認証コードです" + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "このコードを入力してください。" + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String mail) {
    	try {    		
    		MimeMessage message = createMail(mail);
    		javaMailSender.send(message);
    		return number;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return -1;
    	}
    }
	
}
