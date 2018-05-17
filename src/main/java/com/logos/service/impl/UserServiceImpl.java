package com.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.logos.entity.User;
import com.logos.repository.UserRepository;
import com.logos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		String password = user.getPassword();
		System.out.println("Entered password: " + password);
		user.setPassword(passwordEncoder.encode(password));
		System.out.println("Hash password: " + user.getPassword());
		
		userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

}
