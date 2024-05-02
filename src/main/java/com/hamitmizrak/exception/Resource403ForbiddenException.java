package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Authentication : Kullanıcı Login olmuş mu?
// Authorization  : Yetkilendirme anlamına geliyor
// 401: Yetkisiz Giris (Register olmaya zorlar)
// 403: Yasak Giriş (Forbitten) (Kullanıcı Giriş yapmış ancak o sayfaya yetkisi yoktur)
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Resource403ForbiddenException extends RuntimeException{

    // Override
    public Resource403ForbiddenException(String message) {
        super(message);
    }
}
