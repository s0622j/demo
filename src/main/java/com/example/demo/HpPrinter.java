package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
    @Value("${count:200}")
    private int count;
    @Value("${my.name}")
    private String name;


    @Override
    public void print(String message) {
        count--;
        System.out.println("HP 印表機: " + message);
        System.out.println("name: " + name);
        System.out.println("剩餘使用次數: " + count);
    }
}
