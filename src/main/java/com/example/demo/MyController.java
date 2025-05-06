package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;

//    @RequestMapping("/test")
//    public String test() {
//        System.out.println("Hi!");
//        printer.print("!!!!!!!!hello    World ！！！！！");
//        return "Hello World";
//    }

//    @RequestMapping("/product")
//    public String product() {
//        return "第一個是蘋果、第二個是橘子";
//    }

    @RequestMapping("/test")
    public Student test() {
        Student student = new Student();
        student.setId(123);
        student.setName("Judy");
        return student;
    }

    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id) {
        System.out.println("id 的值為: " + id);
        return "請求成功";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("student 中的 id 值為: " + student.getId());
        System.out.println("student 中的 name 值為: " + student.getName());
        return "請求成功";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info) {
        System.out.println("info 的值為: " + info);
        return "請求成功";
    }

    @RequestMapping("/test4/{id}")
    public String test4(@PathVariable Integer id) {
        System.out.println("id 的值為: " + id);
        return "請求成功";
    }
}