package com.logos.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.logos.dto.UserDTO;

import ua.logos.entity.enums.UserRole;


public class UserMapper {

	public static User toSecurityUser(com.logos.entity.User user) {
		return new User(
				user.getLogin(), 
				user.getPassword(),
				AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}

	public static com.logos.entity.User convertToUser(UserDTO userDTO) {
		return new ModelMapper().map(userDTO, com.logos.entity.User.class);
	}
	
	public static UserDTO convertToDto(com.logos.entity.User user) {
		UserDTO dto = new ModelMapper().map(user, UserDTO.class);
		dto.setRole(UserRole.ROLE_CLIENT);
		dto.setPassword("");
		return dto;
	}
	
}
