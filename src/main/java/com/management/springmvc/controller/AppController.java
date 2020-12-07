package com.management.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.springmvc.model.Login;
import com.management.springmvc.model.Registration;
import com.management.springmvc.service.RegistrationService;

@Controller
public class AppController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	RegistrationService registrationService;
	
	
	@GetMapping("/registrationForm")
	public String showForm(Model model) {
		model.addAttribute("registration", new Registration());
		List<String> listOfRoles = new ArrayList<String>();
		listOfRoles.add("Admin");
		listOfRoles.add("Team Leader");
		listOfRoles.add("Team Member");
		model.addAttribute("listOfRoles", listOfRoles);
		return "registrationForm";
	}
	
	@PostMapping("/new")
	public String addUser(@Valid @ModelAttribute("registration") Registration registration, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "registrationForm";
		}
		registrationService.saveUser(registration);
		model.addAttribute("registration", new Registration());
		List<String> listOfRoles = new ArrayList<String>();
		listOfRoles.add("Admin");
		listOfRoles.add("Team Leader");
		listOfRoles.add("Team Member");
		model.addAttribute("listOfRoles", listOfRoles);
		return "login";
	}
	@GetMapping("/login")
	public String loginPage(Model model) {
		List<String> listOfRoles = new ArrayList<String>();
		listOfRoles.add("Admin");
		listOfRoles.add("Team Leader");
		listOfRoles.add("Team Member");
		model.addAttribute("listOfRoles", listOfRoles);
		model.addAttribute("login", new Login());
		
		return "login";
	}
	
	@PostMapping("/validation")
	public String navigatePage(@Valid @ModelAttribute("login") Login login, BindingResult br, Model model) {
		List<Registration> list = registrationService.getAllUsers();
		if(br.hasErrors()) {
			return "login";
		}
		for(int i = 0; i < list.size(); i++) {
			if(login.getUserName().equals(list.get(i).getUserName()) && login.getPassword().equals(list.get(i).getPassword()) && login.getRole().equals(list.get(i).getRole())) {
				System.out.println("validated");
				if(login.getRole().equals("Admin")) {
					System.out.println("Admin HOme"+i);
					return "adminHome";
				}
				else if(login.getRole().equals("Team Leader")) {
					
				}
				else {
					
				}
			}
		}
		return "login";
	}
}

