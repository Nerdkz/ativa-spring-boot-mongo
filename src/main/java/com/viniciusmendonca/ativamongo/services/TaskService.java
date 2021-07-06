package com.viniciusmendonca.ativamongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusmendonca.ativamongo.domain.Task;
import com.viniciusmendonca.ativamongo.dto.TaskDTO;
import com.viniciusmendonca.ativamongo.repository.TaskRepository;
import com.viniciusmendonca.ativamongo.services.exception.ObjectNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository repo;
	
	public List<Task> findAll() {
		return repo.findAll();
	}
	
	public Task findById(String id) {
		Optional<Task> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Task insert(Task obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Task update(Task obj) {
		Task newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Task newObj, Task obj) {
		
		newObj.setName(obj.getName());
		newObj.setDataHour(obj.getDataHour());
		newObj.setDuration(obj.getDuration());
		newObj.setLocal(obj.getLocal());
		newObj.setGuests(obj.getGuests());
		newObj.setAuthor(obj.getAuthor());
	}

	
	public Task fromDTO(TaskDTO objDto) {
		return new Task(objDto.getId(), objDto.getName(), objDto.getDataHour(), objDto.getDuration(), objDto.getLocal(), objDto.getGuests(), objDto.getAuthor());
	}
	
}
