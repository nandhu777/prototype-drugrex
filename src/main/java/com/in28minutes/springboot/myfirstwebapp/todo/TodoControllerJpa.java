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

	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
				
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "search";
	}
	
	
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
	 
		/**
		 *
		 * @return
		 */
		
		
		
		
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
	
	 
//	@RequestMapping("many-form")
//	public String manyForm(@RequestParam("myCountry") String nameSearch,ModelMap model) {
//		String myStr1 = "fever";
//		String myStr2 = "malaria";
//		String myStr3 = "hiv";
//		if(myStr1.equalsIgnoreCase(nameSearch))
//		{   
//			model.addAttribute("searchname",nameSearch);
//			return "fever";
//		}
//		else if(myStr2.equalsIgnoreCase(nameSearch))
//				{   
//			model.addAttribute("searchname",nameSearch);
//				   return "malaria";
//		         }
//		else if(myStr3.equalsIgnoreCase(nameSearch))
//		{ 
//			model.addAttribute("searchname",nameSearch);
//		   return "hiv";
//        }
//         
//		else {
//			
//			return "Hello! What are you learning today?";
//		}
//		
//		
//	
//		
//	}
//
//	
//	
//	
//	
	
	
	//GET, POST
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.addTodo(username, todo.getDescription(), 
//				todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		todoRepository.deleteById(id);
		return "redirect:list-todos";
		
	}

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}