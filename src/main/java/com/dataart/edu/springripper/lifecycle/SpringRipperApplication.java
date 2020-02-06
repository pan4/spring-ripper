package com.dataart.edu.springripper.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringRipperApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringRipperApplication.class, args);
		Quoter quoter = context.getBean(Quoter.class);
		quoter.sayQuote();
	}

}
