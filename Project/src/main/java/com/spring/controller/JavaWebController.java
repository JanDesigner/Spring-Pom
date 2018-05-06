package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaWebController {
	
	@GetMapping("/")
	public String myHome(){
		return "home";
	}
	@GetMapping("/myLoginPage")
	public String myLoginPage() {
		return "myLogin";
	}
	@GetMapping("/leaders")
	public String myLeaders() {
		return "leaders";
	}
	@GetMapping("/admins")
	public String myAdmins() {
		return "admins";
	}
	@GetMapping("/nope")
	public String myNope() {
		return "nope";
	}
	
}
