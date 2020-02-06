package com.dataart.edu.springripper.infra.lib;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(Config.class)
public @interface EnableMain  {
}
