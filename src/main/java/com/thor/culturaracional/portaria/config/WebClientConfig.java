package com.thor.culturaracional.portaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient getWebCLient() {
        return WebClient.builder().build();
    }
}
