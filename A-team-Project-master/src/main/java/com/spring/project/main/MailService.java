package com.spring.project.main;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendMail(String to, String title, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setCc("jjkjadm@gmail.com"); // 참조
			messageHelper.setFrom("jjkjadm@gmail.com", "제주가고싶조_admin"); // 보낸이
			messageHelper.setSubject(title); // 제목
			messageHelper.setTo(to); // 문의한사람
			messageHelper.setText(body, true); // 내용
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}