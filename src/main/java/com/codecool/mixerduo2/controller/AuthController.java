package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.Client;
import com.codecool.mixerduo2.restexceptionhandling.UserAlreadyExistAuthenticationException;
import com.codecool.mixerduo2.model.UserCredentials;
import com.codecool.mixerduo2.repository.ClientRepository;
import com.codecool.mixerduo2.security.JwtTokenServices;
import com.codecool.mixerduo2.security.PasswordEncoderService;
import com.codecool.mixerduo2.service.DataValidateService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins="${main.route}")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private ClientRepository clientRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    private final DataValidateService dataValidateService;

    private PasswordEncoderService pwService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, ClientRepository clientRepository, DataValidateService dataValidateService, PasswordEncoderService passwordEncoderService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
        this.clientRepository = clientRepository;
        this.dataValidateService = dataValidateService;
        this.pwService = passwordEncoderService;
    }

    @PostMapping("/sign_up")
    public ResponseEntity registerUser(@RequestBody UserCredentials userCredentials) throws UserAlreadyExistAuthenticationException {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        //check valid password data
        List<String> errorList = new ArrayList<>();

        if(!dataValidateService.isValid(password, errorList)){
            String error = String.join(",", errorList);
            String errorMessage = "The password must contain at least " + error + "!";
//            ResponseEntity.badRequest().body(errorList);
            return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
        };
        //check if username exists already
        if (clientRepository.findByUsername(username).isPresent()){
            throw new UserAlreadyExistAuthenticationException("Username already exists!");
        } else {
            //save to db
            Client client = Client.builder().username(username).password(pwService.encodePassword(password)).build();
            clientRepository.save(client);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/sign_in")
    public ResponseEntity signin(@RequestBody UserCredentials userCredentials){
        try{
            String username = userCredentials.getUsername();
            String password = userCredentials.getPassword();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            String token = jwtTokenServices.createToken(username, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);
            System.out.println(ResponseEntity.ok(model));
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e){
            throw new BadCredentialsException("Wrong username/password");
        }
    }
}
