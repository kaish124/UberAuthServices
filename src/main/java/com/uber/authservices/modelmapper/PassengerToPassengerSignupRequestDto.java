package com.uber.authservices.modelmapper;

import com.kaish.uber.dto.entity.PassengerBean;
import com.uber.authservices.domain.entity.Passenger;
import com.uber.authservices.dto.PassengerSignupRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassengerToPassengerSignupRequestDto implements MappingConfigurer{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PassengerToPassengerSignupRequestDto(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ModelMapper modelMapper) {

        modelMapper.emptyTypeMap(PassengerSignupRequestDto.class, Passenger.class)
                .addMappings(mapper -> {
                    mapper.using(ctx -> {
                        String password = (String) ctx.getSource();
                        if (ctx.getSource() != null && !password.isEmpty()) {
                            return passwordEncoder.encode(password);
                        }
                        return null;
                    })
                    .map(PassengerSignupRequestDto::getPassword, Passenger::setPassword);
                }).implicitMappings();
    }
}
