package com.logos.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;



import lombok.Data;
import ua.logos.entity.enums.UserRole;

@Data
public class UserDTO {

	private String login;	
private String password;
private int phonenumber;
private String city;
private String street;
private String pic;
private UserRole role;


}
