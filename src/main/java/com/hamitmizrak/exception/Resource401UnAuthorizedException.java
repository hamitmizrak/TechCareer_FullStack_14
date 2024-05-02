package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Authentication : Kullanıcı Login olmuş mu?
// Authorization  : Yetkilendirme
// 401: Yetkisiz Giris (Register olmaya zorlar)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class Resource401UnAuthorizedException extends RuntimeException{

    // Override
    public Resource401UnAuthorizedException(String message) {
        super(message);
    }
}
