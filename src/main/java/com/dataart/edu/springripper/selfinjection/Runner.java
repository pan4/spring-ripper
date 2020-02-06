package com.dataart.edu.springripper.selfinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SomeService bean = context.getBean(SomeService.class);
//        bean.someMethod();
        bean.otherMethod();
    }
}
