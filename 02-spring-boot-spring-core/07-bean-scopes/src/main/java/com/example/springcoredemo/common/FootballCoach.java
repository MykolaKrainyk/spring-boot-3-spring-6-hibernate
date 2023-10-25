package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Take out 30 minutes to practice your ball handling skills!";
    }
}
