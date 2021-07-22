package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greetings;
import com.example.greetingapp.entity.User;
import java.util.List;

public interface IGreetingService {
    Greetings addGreeting(User user);

    Greetings getGreetingById(long id);

    List<Greetings> getAllGreetings();

    Greetings deleteGreeting(long id);

    Greetings updateGreeting(long id,User user);
}
