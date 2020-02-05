package com.codecool.mixerduo2;

import com.codecool.mixerduo2.config.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Mixerduo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mixerduo2Application.class, args);
    }

}
