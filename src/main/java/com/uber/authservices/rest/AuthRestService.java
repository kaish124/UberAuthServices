package com.uber.authservices.rest;

import com.uber.authservices.dto.PassengerSignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthRestService {

    ResponseEntity<?> signUp(PassengerSignupRequestDto  passengerSignupRequestDto);
}
