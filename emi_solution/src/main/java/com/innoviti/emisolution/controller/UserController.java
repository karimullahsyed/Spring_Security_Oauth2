package com.innoviti.emisolution.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoviti.emisolution.model.Users;
import com.innoviti.emisolution.service.UserService;
import com.innoviti.emisolution.serviceImpl.UserAuthenticationServiceImpl;

@RestController
@RequestMapping(value = "/users")
public class UserController {
  
  @Autowired
  private UserService userService;
  
  private static Logger logger = LoggerFactory.getLogger(UserAuthenticationServiceImpl.class);
  
  @GetMapping("/authenticate")
  public ResponseEntity<Principal> user(Principal user) {
	  logger.info("user ");
   return ResponseEntity.<Principal>ok(user);
  }
  
  @GetMapping
  public ResponseEntity<Users> getUserByUsername(Principal principal) {
	  logger.info(" findByUsername ");
    Users user = userService.findByUsername(principal.getName());
    return ResponseEntity.<Users>ok(user);    
  }
}
