package com.uber.authservices.rest.impl;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.dto.PassengerSignupRequestDto;
import com.uber.authservices.rest.AuthRestService;
import com.uber.authservices.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services/v1/auth")
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
}