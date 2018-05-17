package com.logos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.logos.dto.UserDTO;
import com.logos.entity.User;
import com.logos.mapper.UserMapper;
import com.logos.service.UserService;

import ua.logos.cloudinary.CloudinaryService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private CloudinaryService cloudinaryService;
	
	@GetMapping("/login")
	public String showLogin(Principal principal) {
		return principal == null ? "login-form" : "redirect:/";
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new UserDTO());
		return "register-form";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("registerModel") UserDTO userDTO) {
		
		userService.save(UserMapper.convertToUser(userDTO));
		return "redirect:/";
	}
	@GetMapping("/users")
	public String showUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	
	@GetMapping("/{userId}/image")
	public String showUploadImage(@PathVariable int userId, Model model) {
		model.addAttribute("userId", userId);
		return "upload";
	}
	
	@PostMapping("/image/upload")
	public String uploadImage(
			@RequestParam("user_id") String userIdStr,
			@RequestParam("profileImage") MultipartFile file
			) {
		
		String imageUrl = cloudinaryService.uploadFile(file, "");
		User user = userService.findByLogin((String.valueOf(userIdStr)));
		
		user.setProfileImageUrl(imageUrl);
		userService.update(user);
		
		return "redirect:/user/profile/" + userIdStr;
	}
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@GetMapping("/client")
	public String showclientPage(Principal principal, Model model) {
		System.out.println("Username: " + principal.getName());
		
		model.addAttribute("clientProfile", 
				userService.findByLogin(principal.getName()));
		return "client";
	}
}
