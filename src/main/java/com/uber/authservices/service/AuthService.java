package com.uber.authservices.service;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.dto.PassengerSignupRequestDto;
import org.springframework.security.core.userdetails.User;

public interface AuthService {
    PassengerBean signUp(PassengerSignupRequestDto passengerSignupRequestDto);

    PassengerBean signIn(User user);
}
