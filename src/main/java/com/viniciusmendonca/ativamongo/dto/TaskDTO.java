package com.viniciusmendonca.ativamongo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TaskDTO {

	private String id;
	private String name;
	private LocalDateTime dataHour;
	private String duration;
	private String local;
	private List<String> guests;
}
