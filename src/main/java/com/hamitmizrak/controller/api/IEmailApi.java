package com.hamitmizrak.controller.api;

import org.springframework.http.ResponseEntity;

// API INTERFACE (IEmailApi)
// D: Dto
public interface IEmailApi<D> {

    // EMAIL CRUD

    // Email Basic Send Create
    public ResponseEntity<?> basicSendEmail (D d);

    // Email Intermedia Send Create
    public ResponseEntity<?> intermediaSendEmail (D d);

} //end api interface
