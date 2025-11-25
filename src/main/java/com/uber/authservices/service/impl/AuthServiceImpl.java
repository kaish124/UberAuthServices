package com.uber.authservices.service.impl;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.domain.entity.Passenger;
import com.uber.authservices.dto.PassengerSignupRequestDto;
import com.uber.authservices.repository.PassengerRepository;
import com.uber.authservices.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final PassengerRepository passengerRepository;
    private final PasswordEncoder  passwordEncoder;

    @Autowired
    public AuthServiceImpl(ModelMapper modelMapper, PassengerRepository passengerRepository, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passengerRepository = passengerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = false)
    public PassengerBean signUp(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = modelMapper.map(passengerSignupRequestDto, Passenger.class);
        passenger = passengerRepository.save(passenger);
        return  modelMapper.map(passenger, PassengerBean.class);
    }
    @Override
    @Transactional(readOnly = false)
    public PassengerBean signIn(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = passengerRepository.findByEmail(passengerSignupRequestDto.getEmail());
        if(passenger == null || !passwordEncoder.matches(passengerSignupRequestDto.getPassword(), passenger.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }
        return  modelMapper.map(passenger, PassengerBean.class);
    }
}
