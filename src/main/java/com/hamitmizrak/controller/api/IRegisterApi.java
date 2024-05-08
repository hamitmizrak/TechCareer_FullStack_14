package com.hamitmizrak.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

// API INTERFACE (IRegisterApi)
// D: Dto
public interface IRegisterApi<D> {
    // Register SpeedData
    public ResponseEntity<?> registerApiSpeedData(Long data);

    // Register User All Delete
    public ResponseEntity<?> registerApiUserAllDelete();

    /////////////////////////////////////////////////////////
    // REGISTER CRUD
    // Register Create
    public ResponseEntity<?> registerApiCreate(Long rolesId, D d);

    // Register List
    public ResponseEntity<List<D>> registerApiList();

    // Register Find ID
    public ResponseEntity<?> registerApiFindById(Long id);

    // Register Update ID, Object
    public ResponseEntity<?> registerApiUpdateById(Long id, D d);

    // Register Delete ID
    public ResponseEntity<?> registerApiDeleteById(Long id);

    /////////////////////////////////////////////////////////
    // Email adresinden kullanıcı rolünü bulmak

} //end Registerapi interface
