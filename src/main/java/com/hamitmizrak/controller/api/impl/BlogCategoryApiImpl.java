package com.hamitmizrak.controller.api.impl;


import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.business.services.IBlogCategoryServices;
import com.hamitmizrak.controller.api.IBlogCategoryApi;
import com.hamitmizrak.utils.FrontendPortUrl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK 3 7 7 0
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/blog/category/api/v1")
public class BlogCategoryApiImpl implements IBlogCategoryApi<BlogCategoryDto> {

    // Injection
    private final IBlogCategoryServices iCategoryServices;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/blog/category/api/v1/speed/10
    @Override
    @GetMapping(value="/speed/{id}")
    public ResponseEntity<String> categoryApiSpeedData(@PathVariable(name = "id")  Integer data) {
        return  ResponseEntity.ok(iCategoryServices.categorySpeedData(data));
    }

    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    @Override
    @DeleteMapping(value="/delete/all")
    public ResponseEntity<String> categoryApiAllDelete() {
        return ResponseEntity.ok(iCategoryServices.categoryDeleteAll());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody BlogCategoryDto categoryDto) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<BlogCategoryDto>> categoryApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceList());
    }

    // FIND
    // http://localhost:4444/blog/category/api/v1/find/1
    @Override
    @GetMapping(value="/find/{id}")
    public ResponseEntity<?> categoryApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iCategoryServices.categoryServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    @Override
    @PutMapping(value="/update/{id}")
    public ResponseEntity<?> categoryApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody BlogCategoryDto categoryDto) {
        return ResponseEntity.ok().body(iCategoryServices.categoryServiceUpdate(id,categoryDto));
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    @Override
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> categoryApiDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iCategoryServices.categoryServiceDeleteById(id),HttpStatus.OK);
    }

} //end class
