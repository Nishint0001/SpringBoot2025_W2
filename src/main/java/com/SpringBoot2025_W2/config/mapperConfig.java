package com.SpringBoot2025_W2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapperConfig
{
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
