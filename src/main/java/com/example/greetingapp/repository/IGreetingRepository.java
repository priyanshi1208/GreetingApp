package com.example.greetingapp.repository;

import com.example.greetingapp.entity.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greetings, Long> {
}
