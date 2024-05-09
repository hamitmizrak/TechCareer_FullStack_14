package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.EmailDto;
import com.hamitmizrak.business.services.IEmailServices;
import com.hamitmizrak.controller.api.IEmailApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Lombok
@RequiredArgsConstructor
@Log4j2

// API (REST)
@RestController
@RequestMapping("/email/api/v1.0.0")
@CrossOrigin //CORS: Hatası
//@CrossOrigin(origins = ProjectUrl.REACT_FRONTEND_PORT_URL)
//@CrossOrigin(origins = "localhost:3000")
public class EmailApiImpl implements IEmailApi<EmailDto> {

    // Injection
    private final IEmailServices iEmailServices;


    // SEND BASIC Email(Api)
    // http://localhost:4444/email/api/v1.0.0/basic/email
    @PostMapping("/basic/email")
    @Override
    public ResponseEntity<?> basicSendEmail(@Valid @RequestBody EmailDto emailDto) {
       return ResponseEntity.ok(iEmailServices.basicSendEmail(emailDto));
    }

    // SEND INTERMEDIA Email(Api)
    // http://localhost:4444/email/api/v1.0.0/attachment/email
    @PostMapping("/attachment/email")
    @Override
    public ResponseEntity<?> intermediaSendEmail(@Valid @RequestBody EmailDto emailDto) {
        return ResponseEntity.ok(iEmailServices.basicSendEmail(emailDto));
    }

}// end EmailApiImpl
