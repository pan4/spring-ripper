package com.dataart.edu.springripper;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profiling
@Component
public class TerminatorQuoter implements Quoter {

    private String quote = "I'll be back";

    @InjectRandomInt
    private int repeat;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @PostConstruct
    private void init(){
        System.out.println("Phase 2");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println(quote);
        }
    }
}
