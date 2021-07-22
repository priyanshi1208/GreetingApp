package com.example.greetingapp.service;

import com.example.greetingapp.Exception.GreetingException;
import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.entity.Greetings;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";

    @Autowired
    IGreetingRepository greetingRepository;
    @Override
    public Greetings addGreeting(User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.save(new Greetings(message));
    }

    @Override
    public Greetings getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greetings> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greetings deleteGreeting(long id) {
        return greetingRepository.findById(id).
                map(greeting -> {
                    this.greetingRepository.deleteById(id);
                    return greeting;
                }).get();
    }

    @Override
    public Greetings updateGreeting(long id,User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.findById(id).
                map(greeting -> {
                    greeting.setMessage(message);
                    return this.greetingRepository.save(greeting);
                }).get();
    }

}
