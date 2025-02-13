package com.example.demo;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTaask {
	@Scheduled(fixedRate =5000) //Runs every 5 seconds
	public void runTask(){
		System.out.println("Task executed at: "+LocalTime.now());
	}
}
