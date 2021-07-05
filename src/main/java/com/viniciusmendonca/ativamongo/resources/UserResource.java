package com.viniciusmendonca.ativamongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusmendonca.ativamongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<User>> findAll() {
		User vinicius = new User("1", "Vinicius", "vinicius@hotmail.com", "123456");
		User alex = new User("2", "Alex", "alex@hotmail.com", "123456");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(vinicius, alex));
		
		return ResponseEntity.ok().body(list);
	}
}
