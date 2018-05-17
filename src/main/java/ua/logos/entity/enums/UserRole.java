package ua.logos.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
ROLE_DOCTOR("Doctor's job"),ROLE_RECEPTION("visit date"),ROLE_CLIENT("Client's role");
private String rolestr;
}
