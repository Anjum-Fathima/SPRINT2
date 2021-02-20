package com.cg.hsm.service;

import com.cg.hsm.domain.User;

public interface UserServiceImpl 
{
	User saveUser(User user);
	User findByUserName(String userName);
	Iterable<User> getAllUsers();
	void deleteByUserName(String userName);
	void updateUserPassword(String userName, User user);
	String authenticateUser(String userName,String password);
}
