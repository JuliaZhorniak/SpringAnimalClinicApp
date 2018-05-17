package com.logos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import ua.logos.entity.enums.UserRole;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
@ToString(callSuper = true)
public class User extends BaseEntity{
	private String login;	
private String password;
private int phonenumber;
private String city;
private String street;
private String pic;
@OneToMany(mappedBy = "user")
private List<Pet> pet = new ArrayList<>();
@Enumerated(EnumType.ORDINAL)
private UserRole role;
@Column(name = "profile_image_url", length = 500)
private String profileImageUrl;
}
