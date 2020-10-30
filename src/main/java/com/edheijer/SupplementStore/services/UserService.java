package com.edheijer.SupplementStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplementStore.models.User;
import com.edheijer.SupplementStore.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUser(Long id) {
		return userRepository.getOne(id);
	}
	
	public User addUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public void updateUser(Long id, User user) {
		userRepository.saveAndFlush(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
