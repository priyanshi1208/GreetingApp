package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greetings;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @PostMapping("/greeting")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/greeting/{id}")
    public Greetings getById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/greetings")
    public List<Greetings> getAllGreetings(){
        return greetingService.getAllGreetings();
    }

    @DeleteMapping("/greeting/{id}")
    public Greetings deleteById(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }

    @PutMapping("/greeting/{id}")
    public Greetings updateById(@PathVariable Long id, @RequestBody User user){
        return greetingService.updateGreeting(id,user);
    }

}