package com.cg.hsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.User;
import com.cg.hsm.exception.UserNameException;
import com.cg.hsm.repository.UserRepository;

@Service
public class UserService
{
   @Autowired
   private UserRepository userRepository;
   
   public User saveOrUpdate(User user)
   {
	   try 
	   {
		   user.setUserName(user.getUserName().toUpperCase());
		   return userRepository.save(user);
	   }
	   catch(Exception e)
	   {
		 throw new UserNameException("User Name : "+user.getUserName().toUpperCase()+" already exists");  
	   }
	 
   }
   
   
   public User findByUserName(String userName)
   {
	   User user=userRepository.findByUserName(userName.toUpperCase());
	   if(user==null)
	   {
		  throw new UserNameException("User Name : "+userName.toUpperCase()+" does not exists"); 
	   }
	   return user;
   }
   
   public Iterable<User> getAllUsers()
   {
	   return userRepository.findAll();
   }
   
   public void deleteByUserName(String userName)
   {
	   User user = userRepository.findByUserName(userName.toUpperCase());
	   if(user==null)
	   {
		   throw new UserNameException("User Name : "+userName.toUpperCase()+" does not exists"); 
	   }
	   userRepository.delete(user);
   }
}
