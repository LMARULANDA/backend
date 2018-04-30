package com.example.gradlespring.service;

import java.util.List;

import com.example.gradlespring.model.User;

public interface UserService {

	/**
	 * Guarda un usuario	
	 * @param user
	 * @return usuario guardado
	 */

	User save(User user);

	/**
	 * Recupera la lista de usuarios
	 * @return lista de usuarios
	 */
	List<User> findAll();

	/**
	 * Elimina un usuario con el id recibido
	 * @param id
	 */
	void deleteUser(long id);	
}
