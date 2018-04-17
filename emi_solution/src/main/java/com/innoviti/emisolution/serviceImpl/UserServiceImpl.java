package com.innoviti.emisolution.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoviti.emisolution.exception.NotFoundException;
import com.innoviti.emisolution.model.Users;
import com.innoviti.emisolution.repository.UsersRepository;
import com.innoviti.emisolution.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UsersRepository userRepository;
  
  @Override
  public Users findByUsername(String username) {
    Users user = userRepository.findByUserName(username);
    if(user == null){
      throw new NotFoundException("User not found : "+username);
    }
    return user;
  }

 /* @Override
  public Users findByUserId(Integer userId) {
    Users user = userRepository.getOne(userId);
    if(user == null){
      throw new NotFoundException("User not found : "+userId);
    }
    return user;
  }*/
}
