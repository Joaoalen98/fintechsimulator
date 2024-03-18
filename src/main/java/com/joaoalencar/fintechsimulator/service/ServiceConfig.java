package com.joaoalencar.fintechsimulator.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ServiceConfig {

    @Bean
    RestClient restClient() {
        return RestClient.create();
    }

    @Bean
    ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper;
    }
}
