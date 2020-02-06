package com.dataart.edu.springripper.selfinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Autowired
    SomeService someService;

    @Logged
    public void someMethod(){
        System.out.println("Hello world");
    }

    public void otherMethod(){
        someService.someMethod();
    }
}
