package com.edgard.buildexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildexampleApplication implements CommandLineRunner {

    @Value("${build.number}")
    private String buildNumber;

    public static void main(String[] args) {
        SpringApplication.run(BuildexampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BUILD NUMBER GERADO: " + buildNumber);
    }
}
