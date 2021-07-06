package com.viniciusmendonca.ativamongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viniciusmendonca.ativamongo.domain.Task;
import com.viniciusmendonca.ativamongo.dto.TaskDTO;
import com.viniciusmendonca.ativamongo.services.TaskService;

@Controller
@RequestMapping(value = "tasks")
public class TaskResource {
	
	
	@Autowired
	private TaskService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<TaskDTO>> findAll() {
		
		List<Task> list = service.findAll();
		List<TaskDTO> listDto = list.stream().map(x -> new TaskDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity <TaskDTO> findById(@PathVariable String id) {
		
		Task obj = service.findById(id);
		
		return ResponseEntity.ok().body(new TaskDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody TaskDTO objDto) {
		
		Task obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		 
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity <Void> delete(@PathVariable String id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TaskDTO objDto, @PathVariable String id) {
		
		Task obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
}
