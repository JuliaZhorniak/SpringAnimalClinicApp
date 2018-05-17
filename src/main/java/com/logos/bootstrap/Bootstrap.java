package com.logos.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.logos.entity.User;

import com.logos.repository.UserRepository;

import ua.logos.entity.enums.UserRole;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired private UserRepository userRepository;
	
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(userRepository.count() == 0) {
			
			User user = User.builder()
					.login("user")
					.password(passwordEncoder.encode("123"))
					.role(UserRole.ROLE_CLIENT)
					.build();
			userRepository.save(user);
			
			User userREC = User.builder()
					.login("reception")
					.password(passwordEncoder.encode("123"))
					.role(UserRole.ROLE_RECEPTION)
					.build();
			userRepository.save(userREC);
		
		}
	}
}
