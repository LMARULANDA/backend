package com.example.gradlespring.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradlespring.model.User;
import com.example.gradlespring.service.UserService;
import com.example.gradlespring.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//springframework que es un controlador
@RestController
public class UserController {

	@Autowired
	//inyeccion de dependencias
	protected UserService userService;
	
	//objeto mappeador convertir de string json aun objeto user
	protected ObjectMapper mapper;
	//mapper:contruir el json en un objeto
	
	//@RequestBody es un parametro
	@RequestMapping(value = "/saveOrUpdate" ,method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		//userJson transformarlo a user.
		
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"los campos obligatorios no estan diligenciados");
		}
		this.userService.save(user);
		//mensaje para cuando se esta consumiendo un servicio desde postman
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	
	@RequestMapping(value = "/getUsers" ,method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
	}
	
	@RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception {
		this.mapper = new ObjectMapper();
		
		User user = this.mapper.readValue(userJson, User.class);
		
		if(Objects.isNull(user.getId())) {
			throw new Exception("El id esta nulo");
		}
		
		
		this.userService.deleteUser(user.getId());
	}
	
	
	private boolean validate(User user) {
		boolean isValid = true;
		
		if(StringUtils.trimToNull(user.getFirstName()) == null){
			isValid = false;
		}
		if(StringUtils.trimToNull(user.getFirstSurname()) == null) {
			isValid = false;
		}
		if(StringUtils.trimToNull(user.getAddress()) == null) {
			isValid = false;
		}
		return isValid;
	}
	
}
