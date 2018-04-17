package com.innoviti.emisolution.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.emisolution.model.Users;
import com.innoviti.emisolution.service.UserAuthenticationService;
import com.innoviti.emisolution.service.UserService;

@Service
@Transactional
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

  private static Logger logger = LoggerFactory.getLogger(UserAuthenticationServiceImpl.class);

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	logger.info(" loadUserByUsername ");
    Users user = userService.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    String password = user.getPassword();
    String  roles = user.getRoles();
    List<GrantedAuthority> userGrants = new ArrayList<>();
    GrantedAuthority userGrant = new SimpleGrantedAuthority(roles);
    userGrants.add(userGrant);
    logger.info("user roles : {}",  roles);
    return new User(username, password, userGrants);
  }

}

