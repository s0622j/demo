package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Hp02Printer implements Printer {

    private int count;

    @PostConstruct
    public void initialize() {
        count = 5;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println("HP 印表機: " + message);
        System.out.println("剩餘使用次數: " + count);
    }
}
