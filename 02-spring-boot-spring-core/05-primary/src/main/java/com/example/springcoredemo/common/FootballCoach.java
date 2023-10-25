package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Take out 30 minutes to practice your ball handling skills!";
    }
}
