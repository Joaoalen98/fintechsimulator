package com.joaoalencar.fintechsimulator.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ServiceConfig {

    @Bean
    RestClient restClient() {
        return RestClient.create();
    }
}
