package com.viniciusmendonca.ativamongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciusmendonca.ativamongo.domain.Task;
import com.viniciusmendonca.ativamongo.domain.User;
import com.viniciusmendonca.ativamongo.dto.AuthorDTO;
import com.viniciusmendonca.ativamongo.repository.TaskRepository;
import com.viniciusmendonca.ativamongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
		userRepository.deleteAll();
		taskRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "123456789");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "123456789");
		User bob = new User(null, "Bob Grey", "bob@gmail.com", "123456789");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Task task1 = new Task(null, "Daily", "05/07/2021 10:30:45", "01:00", "Sala Teams", Arrays.asList("Vinicius", "Jerferson"), new AuthorDTO(maria));
		Task task2 = new Task(null, "Daily", "06/07/2021 08:45:45", "01:00", "Sala Teams", Arrays.asList("Ana", "Maria"), new AuthorDTO(alex));
		
		taskRepository.saveAll(Arrays.asList(task1, task2));	
	}

}
