package com.cg.hsm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="users")
public class User 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;
   
   @NotBlank(message = "userName is required")
   @Column(updatable=false,unique=true)
   private String userName;
   
   @NotBlank(message = "userPassword is required")
   @Size(min = 8 ,max = 15 ,message = "password size should between 8 to 15 characters")
   private String userPassword;
   
   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date created_On;
   
   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date updated_On;
   
   private String created_By="Admin";
   
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String password) {
	this.userPassword = password;
}
public Date getCreated_On() {
	return created_On;
}
public void setCreated_On(Date created_At) {
	this.created_On = created_At;
}

public String getCreated_By() {
	return created_By;
}
public void setCreated_By(String created_By) {
	this.created_By = created_By;
}
@PrePersist
public void onCreate()
{
	this.created_On=new Date();
}
@PreUpdate
public void onUpdate()
{
	this.updated_On=new Date();
}
}
