package com.viniciusmendonca.ativamongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciusmendonca.ativamongo.domain.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

}
