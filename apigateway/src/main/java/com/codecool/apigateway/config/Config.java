package com.codecool.apigateway.config;

import com.codecool.apigateway.service.DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  implements CommandLineRunner {

    @Autowired
    private DataProviderService dataProviderService;

    @Override
    public void run(String... args) throws Exception {
        dataProviderService.buildClient();
    }
}
