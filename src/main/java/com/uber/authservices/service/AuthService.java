package com.uber.authservices.service;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.dto.PassengerSignupRequestDto;

public interface AuthService {
    PassengerBean signUp(PassengerSignupRequestDto passengerSignupRequestDto);

    PassengerBean signIn(PassengerSignupRequestDto passengerSignupRequestDto);
}
