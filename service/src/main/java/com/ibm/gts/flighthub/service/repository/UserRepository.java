package com.ibm.gts.flighthub.service.repository;

import java.util.List;

import com.ibm.gts.flighthub.service.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {

  public User findByName(String name);
  public List<User> findByAge(int age);

}