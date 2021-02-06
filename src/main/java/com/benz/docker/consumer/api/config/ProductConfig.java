package com.benz.docker.consumer.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProductConfig {

    @Bean
    public WebClient.Builder webClient()
    {
      return WebClient.builder();
    }
}
