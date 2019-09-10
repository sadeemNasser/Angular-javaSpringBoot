package com.sadeem.springboot.GoodLifeApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.sadeem.springboot.GoodLifeApp.entity.Goal;
import com.sadeem.springboot.GoodLifeApp.entity.User;
//import com.sadeem.springboot.GoodLifeApp.service.GoalService;
import com.sadeem.springboot.GoodLifeApp.service.UserService;

@RestController
public class UserRestController {

	
   	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService=theUserService;
	}
	
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> Register(@RequestBody User theUser) {
		
		
		if(userService.findByEmail(theUser.getEmail())!=null)
			return new ResponseEntity<String>("user Email are already Registered",HttpStatus.NOT_ACCEPTABLE);

		
		theUser.setID(0);
		userService.Register(theUser);
		return new ResponseEntity<String>("the user added successfuly",HttpStatus.ACCEPTED);

	//	return theUser;
		//return "the user added successfuly";
	}
//	@GetMapping(produces = "application/json")
//	@RequestMapping({ "/validateLogin" })
//	@CrossOrigin(origins = "http://localhost:4200")
//	public User validateLogin() {
//		return userService.findByEmail("Sadeem@gmail.com");
//	}
    
    
	/*
	 * 
	 * 

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }



        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    */
}
