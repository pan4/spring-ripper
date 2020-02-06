package com.dataart.edu.springripper.infra.lib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    String str1(){
        return "str1";
    }

    @Bean
    String str2(){
        return "str2";
    }
}
