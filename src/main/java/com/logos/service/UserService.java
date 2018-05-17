package com.logos.service;

import java.util.List;

import com.logos.entity.User;

public interface UserService {
	void save(User user);
	
	User findById(Long id);
	
	User findByLogin(String login);
	
	List<User> findAll();
	void update(User user);
}
