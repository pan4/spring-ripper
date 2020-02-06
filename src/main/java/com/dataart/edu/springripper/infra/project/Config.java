package com.dataart.edu.springripper.infra.project;

import com.dataart.edu.springripper.infra.lib.EnableMain;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@EnableMain
public class Config {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
