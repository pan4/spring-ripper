package com.dataart.edu.springripper.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.awt.Color;
import java.util.Random;

public class Config {

    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

}
