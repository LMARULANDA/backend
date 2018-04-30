package com.example.gradlespring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gradlespring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@SuppressWarnings("unchecked")
	User save(User user);
	
}
