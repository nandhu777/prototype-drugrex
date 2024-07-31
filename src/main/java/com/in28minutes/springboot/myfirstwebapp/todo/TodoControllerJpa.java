package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")

public class TodoControllerJpa {

	@RequestMapping("many-form")
	public String manyForm(@RequestParam("myCountry") String nameSearch,ModelMap model) {
		
		 List<String> arr = new ArrayList<String>(2); 
		  
	        // using add() to initialize values 
	        // [1, 2, 3, 4] 
	        arr.add("fever"); 
	        arr.add("malaria"); 
	        arr.add("hiv");
	        String str1="fever";
	        String str2="malaria";
	        String str3="hiv";
	  
	        // use contains() to check if the element 
	        // 2 exits or not 
	        
	        String convertedName=nameSearch.toLowerCase();
	        boolean ans =arr.contains(convertedName);
	  
	        if (convertedName.equalsIgnoreCase(str1)) 
	        {
	        	
	    		model.addAttribute("search", nameSearch);
	    		return "bigform";
	        }
	        else if(convertedName.equalsIgnoreCase(str2))
	        {

	    		model.addAttribute("search", nameSearch);
	    		return "bigform1";
	        }
	        else if(convertedName.equalsIgnoreCase(str3))
	        {

	    		model.addAttribute("search", nameSearch);
	    		return "bigform2";
	        }  
	        
	        else
	            return "welcome";
	}

	
	
	@RequestMapping("/picform")
	public String picForm(
			@RequestParam("age") Integer age,
			@RequestParam("reaction") String reaction,
			@RequestParam("sex") String sex,
			@RequestParam("drug") String Drug,
			ModelMap model) {
		
		model.addAttribute("Age", age);
		model.addAttribute("Onset", reaction);
		model.addAttribute("Sex", sex);
		model.addAttribute("Drug", Drug);
		
		
	            return "feverimg";
	}
	

	
	@RequestMapping("/contact")
	public String contactForm() {
	
		
	            return "contact";
	}
	

		@Autowired
		private MailService notificationService;
	 
		@Autowired
		private User user;
		
		@RequestMapping("/send-mail")
		@ResponseBody
		public String send(@RequestParam("Name") String name,
				@RequestParam("Email") String emailAddress,
				@RequestParam("Message") String text,
				ModelMap model) {
              user.setName(name);
              user.setEmailAddress(emailAddress);
              user.setText(text);
			try {
				notificationService.sendEmail(user);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "Congratulations! Your mail has been send to the user.";
		}
	 
		/**
		 *
		 * @return
		 * @throws MessagingException
		 */
		@RequestMapping("send-mail-attachment")
		public String sendWithAttachment(@RequestParam("Name") String name,
		@RequestParam("Email") String emailAddress,
		@RequestParam("Message") String text,
		ModelMap model) throws MessagingException {
			user.setName(name);
            user.setEmailAddress(emailAddress);
            user.setText(text);
		
			try {
				notificationService.sendEmailWithAttachment(user);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "welcome";
		}
	
	 

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}