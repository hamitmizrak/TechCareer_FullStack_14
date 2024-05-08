package com.hamitmizrak.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

// API INTERFACE (IRoleApi)
// D: Dto
public interface IRoleApi<D> {

    // ROLE CRUD
    // Role Create
    public ResponseEntity<?> roleApiCreate(D d);

    // Role List
    public ResponseEntity<List<D>> roleApiList();

    // Role Find ID
    public ResponseEntity<?> roleApiFindById(Long id);

    // Role Update ID, Object
    public ResponseEntity<?> roleApiUpdateById(Long id, D d);

    // Role Delete ID
    public ResponseEntity<?> roleApiDeleteById(Long id);

} //end api interface
