package com.innoviti.emisolution.service;

import com.innoviti.emisolution.model.Users;

public interface UserService {
	
  Users findByUsername(String username);
  
  //Users findByUserId(Integer userId);
  
}
