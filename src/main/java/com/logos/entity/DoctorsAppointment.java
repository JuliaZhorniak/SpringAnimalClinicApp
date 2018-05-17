package com.logos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.entity.enums.UserRole;
import ua.logos.entity.enums.UserStatus;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctorsapp")
@ToString(callSuper = true)
public class DoctorsAppointment extends BaseEntity{
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pet_id")
	private DoctorsAppointment pet;
}
