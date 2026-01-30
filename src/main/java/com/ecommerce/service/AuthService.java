package com.ecommerce.service;

import com.ecommerce.dto.LoginRequest;
import com.ecommerce.dto.RegisterRequest;

public interface AuthService {
	
	public void register(RegisterRequest registerRequest);
	
	public String login(LoginRequest request);
	

}
