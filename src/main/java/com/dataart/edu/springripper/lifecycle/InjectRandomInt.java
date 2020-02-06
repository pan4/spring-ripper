package com.dataart.edu.springripper.lifecycle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min = 2;
    int max = 7;
}
