package com.ibm.gts.flighthub.processor.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    
    @Id
    public String id;

    private String name;
    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

}
