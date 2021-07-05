package com.viniciusmendonca.ativamongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciusmendonca.ativamongo.domain.User;
import com.viniciusmendonca.ativamongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "123456789");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "123456789");
		User bob = new User(null, "Bob Grey", "bob@gmail.com", "123456789");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
