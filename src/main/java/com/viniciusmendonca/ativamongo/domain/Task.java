package com.viniciusmendonca.ativamongo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private Date dataHour;
	private String duration;
	private String local;
	private List<String> guests;
	private User author;
	
	
	public Task() {
		
	}


	public Task(String id, String name, Date dataHour, String duration, String local, List<String> guests, User author) {
		super();
		this.id = id;
		this.name = name;
		this.dataHour = dataHour;
		this.duration = duration;
		this.local = local;
		this.guests = guests;
		this.author = author;
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


	public Date getDataHour() {
		return dataHour;
	}


	public void setDataHour(Date dataHour) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}


}
