package com.ibm.gts.flighthub.processor.repository;

import java.util.List;

import com.ibm.gts.flighthub.processor.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  public User findByName(String name);
  public List<User> findByAge(int age);

}