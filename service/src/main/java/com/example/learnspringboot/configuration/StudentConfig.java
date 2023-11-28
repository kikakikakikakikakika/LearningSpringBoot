package com.example.learnspringboot.configuration;

import com.example.learnspringboot.model.Student;
import com.example.learnspringboot.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {

            Student mary = Student.builder()
                    .name("Mary")
                    .email("mary123@gmail.com")
                    .dateOfBirth(LocalDate.of(2002, JANUARY, 1))
                    .build();

            Student ivan = Student.builder()
                    .name("Ivan")
                    .email("ivan456@gmail.com")
                    .dateOfBirth(LocalDate.of(2004, JANUARY, 2))
                    .build();

            repository.saveAll(List.of(mary, ivan));

        };

    }

}
