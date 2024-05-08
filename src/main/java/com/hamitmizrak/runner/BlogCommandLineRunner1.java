package com.hamitmizrak.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// LOMBOK
@RequiredArgsConstructor
@Log4j2

// Bean
@Configuration
public class BlogCommandLineRunner1 {

    // Injection
    /*
    rol ekle
    register
    email

    * */

    @Bean
    public CommandLineRunner blogRunner(){
        log.info("Command Line Runner Bean-1");
        System.out.println("Command Line Runner Bean-1");
        return null;
    }

} //end BlogCommandLineRunner1
