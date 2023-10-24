package com.example.springcoredemo.common;

import com.example.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run 5 kilometers!";
    }
}
