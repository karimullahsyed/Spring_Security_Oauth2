package com.innoviti.emisolution.repository;

import com.innoviti.emisolution.model.Users;

public interface UsersRepository extends BaseRepository<Users, Integer> {
	
  Users findByUserName(String username);
  
}
