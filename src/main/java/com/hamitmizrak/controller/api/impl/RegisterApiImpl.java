package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterServices;
import com.hamitmizrak.controller.api.IRegisterApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Lombok
@RequiredArgsConstructor
@Log4j2

// API (REST)
@RestController
@RequestMapping("/register/api/v1.0.0")
@CrossOrigin //CORS: Hatası
//@CrossOrigin(origins = ProjectUrl.REACT_FRONTEND_PORT_URL)
//@CrossOrigin(origins = "localhost:3000")
public class RegisterApiImpl implements IRegisterApi<RegisterDto> {

    // Injection
    private final IRegisterServices iRegisterServices;

    // Error
    private ApiResult apiResult;

    /////////////////////////////////////////////////////////////

    // SPEED DATA
    // http://localhost:4444/register/api/v1.0.0/speed/data
    @Override
    @GetMapping("/speed/data")
    public ResponseEntity<?> registerApiSpeedData(Long key) {
        return ResponseEntity.ok(iRegisterServices.registerSpeedData(key));
    }

    // USER ALL DELETE
    // http://localhost:4444/register/api/v1.0.0/all/delete
    @Override
    @GetMapping("/all/delete")
    public ResponseEntity<?> registerApiUserAllDelete() {
        return ResponseEntity.ok(iRegisterServices.registerAllUSerDelete());
    }

    /////////////////////////////////////////////////////////////
    // REGISTER CRUD

    // CREATE Register(Api)
    // http://localhost:4444/register/api/v1.0.0/create/1
    @Override
    @PostMapping("/create/{roles_id}")
    public ResponseEntity<?> registerApiCreate(
            @PathVariable(name="roles_id",required = false) Long rolesId,
            @Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(iRegisterServices.registerServiceCreate(rolesId,registerDto));
    }

    // LIST Register(Api)
    // http://localhost:4444/register/api/v1.0.0/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<RegisterDto>> registerApiList() {
        return ResponseEntity.ok(iRegisterServices.registerServiceList());
    }

    // FIND Register(Api)
    // http://localhost:4444/register/api/v1.0.0/find
    // http://localhost:4444/register/api/v1.0.0/find/0
    // http://localhost:4444/register/api/v1.0.0/find/1
    @Override
    @GetMapping({"/find","/find/{id}"})
    public ResponseEntity<?> registerApiFindById( @PathVariable(name="id",required = false) Long id) {
        return ResponseEntity.ok(iRegisterServices.registerServiceFindById(id));
    }

    // UPDATE Register(Api)
    // http://localhost:4444/register/api/v1.0.0/update
    // http://localhost:4444/register/api/v1.0.0/update/0
    // http://localhost:4444/register/api/v1.0.0/update/1
    @Override
    @PutMapping({"/update","/update/{id}"})
    public ResponseEntity<?> registerApiUpdateById(
            @PathVariable(name="id",required = false) Long id,
            @Valid @RequestBody  RegisterDto registerDto) {
        return ResponseEntity.ok(iRegisterServices.registerServiceUpdateById(id,registerDto));
    }

    // DELETE Register(Api)
    // http://localhost:4444/register/api/v1.0.0/delete
    // http://localhost:4444/register/api/v1.0.0/delete/0
    // http://localhost:4444/register/api/v1.0.0/delete/1
    @Override
    @DeleteMapping({"/delete","/delete/{id}"})
    public ResponseEntity<?> registerApiDeleteById(@PathVariable(name="id",required = false) Long id) {
        return ResponseEntity.ok(iRegisterServices.registerServiceDeleteById(id));
    }

}// end RegisterApiImpl
