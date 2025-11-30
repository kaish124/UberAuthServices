package com.uber.authservices.rest.impl;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.dto.PassengerSignupRequestDto;
import com.uber.authservices.rest.AuthRestService;
import com.uber.authservices.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/services/v1/auth")
public class AuthRestServiceImpl implements AuthRestService {

    private final AuthService authService;

    @Autowired
    public AuthRestServiceImpl(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup/passenger")
    @Override
    public ResponseEntity<?> signUp(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto) {
        return new ResponseEntity<>(authService.signUp(passengerSignupRequestDto),  HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/signin/passenger")
    public ResponseEntity<?> signIn(Principal principal) {
        try {
            return new ResponseEntity<>(authService.signIn((User) ((Authentication) principal).getPrincipal()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}