package com.ibm.gts.flighthub.service;

import org.springframework.boot.CommandLineRunner;

import com.ibm.gts.flighthub.service.model.User;

import com.ibm.gts.flighthub.service.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(ServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    // save a couple of customers
    repository.save(new User("Marcelo", 48));
    repository.save(new User("Roberto", 46));

    // fetch all customers
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for (User user : repository.findAll()) {
      System.out.println(user);
    }
    System.out.println();

    // fetch an individual customer
    System.out.println("User found with findByName('Marcelo'):");
    System.out.println("--------------------------------");
    System.out.println(repository.findByName("Marcelo"));

    System.out.println("User found with findByAge(46):");
    System.out.println("--------------------------------");
    for (User user : repository.findByAge(46)) {
      System.out.println(user);
    }

  }

}
