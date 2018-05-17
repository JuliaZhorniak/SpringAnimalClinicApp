package com.logos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	@PreAuthorize("isAnonymous()")
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@PreAuthorize("isAnonymous()")
	@GetMapping("/doctor'sinfo")
	public String showDoctorInfo() {
		return "doctor'sinfo";
	}

	
	
}
