package com.cg.hsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.User;
import com.cg.hsm.exception.UserNameException;
import com.cg.hsm.repository.UserRepository;

@Service
public class UserService implements UserServiceImpl {
	@Autowired
	private UserRepository userRepository;

	// Adding user details into the table
	@Override
	public User saveUser(User user) {
		try {
			user.setUserName(user.getUserName().toUpperCase());
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserNameException("User Name : " + user.getUserName().toUpperCase() + " already exists");
		}

	}

	// Finding user details using userName
	@Override
	public User findByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) {
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		return user;
	}

	// Finding all users
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Deleting a user based on userName
	@Override
	public void deleteByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) {
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		userRepository.delete(user);
	}

	// Updating user password
	@Override
	public void updateUserPassword(String userName, User user)
	{
		userRepository.save(user);
	}
	
	//Authenticating the user
	@Override
	public String authenticateUser(String userName,String userPassword)
	{
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) 
		{
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		if(user.getUserPassword().equalsIgnoreCase(userPassword))
		{
			return "Entry granted";
		}
		else
		{
			return "Please provide correct credentials";
		}
	}

}
