package com.innoviti.emisolution.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "unipay_user_staging")
public class Users implements Serializable {

  private static final long serialVersionUID = -3788391832239645648L;

  
  @Id
  @Column(name = "loginattempts", nullable = false, unique = true, columnDefinition = "smallint unsigned")
  private Integer roleId;
  
  
  @Column(name = "user_name", nullable = false, unique = true, length = 45)
  private String userName;

  @JsonIgnore
  @Column(name = "user_password", nullable = false)
  private String password;


  @JsonIgnore
  @Column(name = "user_role", nullable = false)
  private String roles;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

public String getRoles() {
	return roles;
}

public void setRoles(String roles) {
	this.roles = roles;
}


 

}
