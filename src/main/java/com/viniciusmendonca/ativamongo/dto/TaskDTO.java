package com.viniciusmendonca.ativamongo.dto;

import java.io.Serializable;
import java.util.List;

import com.viniciusmendonca.ativamongo.domain.Task;

public class TaskDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String dataHour;
	private String duration;
	private String local;
	private List<String> guests;
	private AuthorDTO author;
	
	
	public TaskDTO() {
		
	}


	public TaskDTO(Task obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.dataHour = obj.getDataHour();
		this.duration = obj.getDuration();
		this.local = obj.getLocal();
		this.guests = obj.getGuests();
		this.author = obj.getAuthor();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDataHour() {
		return dataHour;
	}


	public void setDataHour(String dataHour) {
		this.dataHour = dataHour;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public List<String> getGuests() {
		return guests;
	}


	public void setGuests(List<String> guests) {
		this.guests = guests;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
