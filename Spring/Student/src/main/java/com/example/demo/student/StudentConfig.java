package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            var studentHans = new Student("Hans", "hans@pilz.de", LocalDate.of(1925, 12, 1));
            var studentMartin = new Student("Martin", "mabi@pilz.de", LocalDate.of(1945, 7, 2));

            repository.saveAll(List.of(studentHans, studentMartin));
        };
    }
}
