package com.uber.authservices.rest;

import com.uber.authservices.dto.PassengerSignupRequestDto;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface AuthRestService {

    ResponseEntity<?> signUp(PassengerSignupRequestDto  passengerSignupRequestDto);

    ResponseEntity<?> signIn(Principal principal);
}
