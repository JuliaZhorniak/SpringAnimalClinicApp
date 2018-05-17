package com.logos;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final String ROLE_CLIENT = "/client";
	private final String ROLE_RECEPTION = "/reception";

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	private void handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication
			) throws IOException {
		
		String targetUrl = determainteTargetUrl(authentication);
		
		if(response.isCommitted()) {
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	private String determainteTargetUrl(Authentication authentication) {
		boolean isClient= false;
		boolean isReception = false;
		
		Collection<? extends GrantedAuthority> authorities =
					authentication.getAuthorities();
		
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("ROLE_CLIENT")) {
				isClient = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("ROLE_RECEPTION")) {
				isReception = true;
				break;
			}
		}
		
		if(isClient) {
			return ROLE_CLIENT;
		} else if(isReception) {
			return ROLE_RECEPTION;
		}
		
		return null;
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

}
