package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.RoleDto;
import com.hamitmizrak.business.services.IRoleService;
import com.hamitmizrak.controller.api.IRoleApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

// Lombok
@RequiredArgsConstructor
@Log4j2

// API (REST)
@RestController
@RequestMapping("/role/api/v1.0.0")
@CrossOrigin //CORS: Hatası
//@CrossOrigin(origins = ProjectUrl.REACT_FRONTEND_PORT_URL)
//@CrossOrigin(origins = "localhost:3000")
public class RoleApiImpl implements IRoleApi<RoleDto> {

    // Injection
    private final IRoleService iRoleService;

    // Error
    private ApiResult apiResult;


    // CREATE Role(Api)
    // http://localhost:4444/role/api/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> roleServiceCreate(@Valid @RequestBody RoleDto roleDtoData) {
        RoleDto roleCreateApi=(RoleDto)iRoleService.roleServiceCreate(roleDtoData);

        // Eğer kaydederken null değer gelirse
        if(roleCreateApi==null){
            ApiResult apiResultCreate=ApiResult.builder()
                    .status(404)
                    .error("Role Eklenmedi")
                    .message("Role Dto bulunmadı")
                    .path("localhost:4444/role/api/v1.0.0/create")
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.status(404).body(apiResultCreate);
        }
        else if(roleCreateApi.getRoleId()==0){
            ApiResult apiResultCreate=ApiResult.builder()
                    .status(400)
                    .error("Role Eklenmedi")
                    .message("Role Dto Bad Request")
                    .path("localhost:4444/role/api/v1.0.0/create")
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.status(400).body(apiResultCreate);
        }
        return ResponseEntity.status(201).body(iRoleService.roleServiceCreate(roleDtoData));
    }

    // LIST Role(Api)
    // http://localhost:4444/role/api/v1.0.0/list
    @GetMapping("/list")
    @Override
    public ResponseEntity<List<RoleDto>> roleServiceList() {
        return ResponseEntity.ok(iRoleService.roleServiceList());
    }

    //FIND Role(Api)
    @Override
    public ResponseEntity<?> roleServiceFindById(Long id) {
        return null;
    }

    // UPDATE Role(Api)
    @Override
    public ResponseEntity<?> roleServiceUpdateById(Long id, @Valid @RequestBody RoleDto roleDto) {
        return null;
    }

    // DELETE Role(Api)
    @Override
    public ResponseEntity<?> roleServiceDeleteById(Long id) {
        return null;
    }

}// end RoleApiImpl
