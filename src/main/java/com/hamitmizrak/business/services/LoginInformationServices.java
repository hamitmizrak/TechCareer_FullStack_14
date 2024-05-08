package com.hamitmizrak.business.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// LOMBOK
@Log4j2
@Service
public class LoginInformationServices {

    // Sisteme Giriş yapmış kullanıcı Bilgilerini alan Method
    public Optional<String> isLogin(){
        // Database ile Login girişi yapmış kullanıcı bilgilerini almak
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        // Eğer Kullanıcı sisteme giriş yapmışsa Session bilgilerini almak
        if(authentication!=null && authentication.isAuthenticated()){
            log.warn("Sistemde Kullanıcı Vardır");
            System.out.println("Name: "+authentication.getName());
            System.out.println("Principal: "+authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        /*
        else if(authentication==null && !authentication.isAuthenticated()){
            log.error("Sistemde Kullanıcı Yoktur");
            return Optional.empty();
        }
        */
        return null;
    } //end isLogin

} //end LoginInformationServices
