package com.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
@ToString(callSuper = true)
public class Pet extends BaseEntity{
private int age;
@Column(name = "name")
private String name;
private String colour;
private String weight;
private String pic;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

}
