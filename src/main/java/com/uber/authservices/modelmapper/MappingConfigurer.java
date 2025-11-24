package com.uber.authservices.modelmapper;

import org.modelmapper.ModelMapper;

public interface MappingConfigurer {
    void configure(ModelMapper modelMapper);
}
