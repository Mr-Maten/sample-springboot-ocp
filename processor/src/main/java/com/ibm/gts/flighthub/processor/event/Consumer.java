package com.ibm.gts.flighthub.processor.event;

import java.io.IOException;

import com.ibm.gts.flighthub.processor.model.User;
import com.ibm.gts.flighthub.processor.repository.UserRepository;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private UserRepository repository; 

    @Autowired
    Consumer(UserRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        JSONObject json = new JSONObject(message);
        User user = new User(json.getString("name"), json.getInt("age"));
        logger.info(String.format("#### -> Consumed message -> %s", user));
        repository.save(user);
    }

}