package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.Client;
import com.codecool.mixerduo2.model.UserCredentials;
import com.codecool.mixerduo2.repository.ClientRepository;
import com.codecool.mixerduo2.security.JwtTokenServices;
import com.codecool.mixerduo2.security.PasswordEncoderService;
import com.codecool.mixerduo2.service.DataValidateService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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
    public ResponseEntity registerUser(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();
        String firstname = userCredentials.getFirstname();
        String lastname = userCredentials.getLastname();
        String email = userCredentials.getEmail();
        Map<Object, Object> model = new HashMap<>();

        List<String> errorList = new ArrayList<>();

        if(!dataValidateService.isNotEmptyName(firstname, errorList)){
            String error = String.join(" ", errorList);
            String errorMessage = "The firstname " + error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        };

        if(!dataValidateService.isNotEmptyName(lastname, errorList)){
            String error = String.join(" ", errorList);
            String errorMessage = "The lastname " + error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        };

        if(!dataValidateService.isValidEmail(email, errorList)){
            String error = String.join(" ", errorList);
            String errorMessage =  error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        };
        //check if username exists already
        if (clientRepository.findByUsername(username).isPresent()){
            model.put("correct", false);
            model.put("msg", "Username already exists!");
            return ResponseEntity.ok(model);
        }
        if (username.length() < 4){
            model.put("correct", false);
            model.put("msg", "Username must be at least 4 characters long!");
            return ResponseEntity.ok(model);
        }

        if(!dataValidateService.isValid(password, errorList)){
            String error = String.join(",", errorList);
            String errorMessage = "The password must contain at least " + error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        }
        //save to db
        Cart newCart = new Cart();
        Client client = Client.builder().username(username).password(pwService.encodePassword(password)).firstname(firstname).lastname(lastname).email(email).cart(newCart).roles(Arrays.asList("ROLE_USER")).build();
        newCart.setClient(client);
        clientRepository.save(client);

        List<String> roles = Arrays.asList("ROLE_USER");
        String token = jwtTokenServices.createToken(username, roles);
        model.put("correct", true);
        model.put("username", username);
        model.put("roles", roles);
        model.put("token", token);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/sign_in")
    public ResponseEntity signin(@RequestBody UserCredentials userCredentials){
        Map<Object, Object> model = new HashMap<>();
        try{
            String username = userCredentials.getUsername();
            String password = userCredentials.getPassword();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            String token = jwtTokenServices.createToken(username, roles);
            model.put("correct", true);
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e){
            model.put("correct", false);
            model.put("msg", "Wrong username/password!");
            return ResponseEntity.ok(model);
        }
    }
}
