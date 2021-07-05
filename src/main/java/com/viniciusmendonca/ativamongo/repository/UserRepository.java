package com.viniciusmendonca.ativamongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciusmendonca.ativamongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
