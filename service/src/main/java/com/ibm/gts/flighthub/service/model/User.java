package com.ibm.gts.flighthub.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

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
