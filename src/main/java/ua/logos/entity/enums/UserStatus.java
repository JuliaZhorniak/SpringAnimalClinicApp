package ua.logos.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {

	ACTIVE("ACTIVE"), ACTIVATION_PENDING("PENDING"), NOT_ACTIVATED("NOT ACTIVATED");
	
	private String status;
	
}
