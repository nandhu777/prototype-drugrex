package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
 
 
/**
* 
* @author Mukuljaiswal
*
*/
@Service
public class MailService {
 
	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;
 
	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
 
	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */
 
	public void sendEmail(User user) throws MailException {
 
		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
 
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");
 
		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
 
	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(User user) throws MailException, MessagingException {
 
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		String MainText="Hey " +user.getName()+","+"\n"+"We received your Request for "+"\n" +user.getText()+"\n";
 
		helper.setTo(user.getEmailAddress());
		helper.setSubject("Drug Reaction Prototype");
		helper.setText(MainText+"We have attached the Document of our pdf for your reference with this email"+"\n"+"Thank you,"+"\n"+"Nash");	
 
       ClassPathResource classPathResource = new ClassPathResource("sample1.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);
 
		javaMailSender.send(mimeMessage);
	}
 
}