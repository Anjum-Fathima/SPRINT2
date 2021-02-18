package com.cg.hsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.User;
import com.cg.hsm.exception.UserNameException;
import com.cg.hsm.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// Adding user details into the table
	public User saveUser(User user) {
		try {
			user.setUserName(user.getUserName().toUpperCase());
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserNameException("User Name : " + user.getUserName().toUpperCase() + " already exists");
		}

	}

	// Finding user details using userName
	public User findByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) {
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		return user;
	}

	// Finding all users
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Deleting a user based on userName
	public void deleteByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) {
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		userRepository.delete(user);
	}

	// Updating user password
	public void updateUserPassword(String userName, User user) {
		userRepository.save(user);
	}

}
