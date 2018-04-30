package com.example.gradlespring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradlespring.dao.UserRepository;
import com.example.gradlespring.model.User;

@Service
public class UserServiceImpl implements UserService {

	//inyeccion de dependencias
	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	
}
