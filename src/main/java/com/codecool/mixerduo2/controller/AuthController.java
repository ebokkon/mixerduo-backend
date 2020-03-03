package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.UserCredentials;
import com.codecool.mixerduo2.security.JwtTokenServices;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/sign_up")
    public HttpStatus registerUser(@RequestBody UserCredentials userCredentials){
        //check valid sign up data
        //check username doesn't exist already
        //save to db
        return HttpStatus.ACCEPTED;
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
