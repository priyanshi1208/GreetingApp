package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greetings;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greetings greetings(@RequestParam(value = "name",defaultValue = "world")String name){
        return new Greetings(counter.incrementAndGet(),String.format(template,name));
    }
    @PostMapping("/greetings/post")
    public Greetings postGreetings(@RequestBody Greetings greetings){
        return greetings;
    }
    @PutMapping("/greetings/put/{id}")
    public Greetings putGreetings(@PathVariable long id,@RequestParam(value = "name")String name){
        return new Greetings(id,String.format(template,name));
    }

}
