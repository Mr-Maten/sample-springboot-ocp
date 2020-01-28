package com.ibm.gts.flighthub.processor;

import com.ibm.gts.flighthub.processor.event.Producer;
import com.ibm.gts.flighthub.processor.model.User;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/kafka")
public class ProcessorApplication {

	private final Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

    @Autowired
    ProcessorApplication(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") int age) {
        JSONObject user = new JSONObject(new User(name, age));
        producer.sendMessage(user.toString());
    }	

}
