package com.codecool.apigateway.service;

import com.codecool.apigateway.security.PasswordEncoderService;
import com.codecool.apigateway.model.Client;
import com.codecool.apigateway.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataProviderService {

    private ClientRepository clientRepository;

    private PasswordEncoderService pwService;


    public DataProviderService( ClientRepository clientRepository, PasswordEncoderService passwordEncoderService) {
        this.clientRepository = clientRepository;
        this.pwService = passwordEncoderService;
    }

    public void buildClient() {
        Client admin = Client.builder()
                .username("admin")
                .password(pwService.encodePassword("stars"))
                .roles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"))
                .cartId(Long.valueOf(1) )
                .build();
        clientRepository.save(admin);


        Client user = Client.builder()
                .username("zuzu")
                .password(pwService.encodePassword("secret"))
                .firstname("John")
                .lastname("Smith")
                .email("john@smith.com")
                .roles(Arrays.asList("ROLE_USER"))
                .cartId(Long.valueOf(2))
                .build();
        clientRepository.save(user);
    }

}
