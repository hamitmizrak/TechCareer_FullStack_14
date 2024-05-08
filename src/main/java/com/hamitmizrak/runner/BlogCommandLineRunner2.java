package com.hamitmizrak.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// LOMBOK
@RequiredArgsConstructor
@Log4j2

@Component // Spring Boot bir parçasısın.
public class BlogCommandLineRunner2 implements CommandLineRunner{
    // Injection
    @Override
    public void run(String... args) throws Exception {
        log.info("Command Line Runner Bean-2");
        System.out.println("Command Line Runner Bean-2");
    }

} //end BlogCommandLineRunner1
