package com.hamitmizrak.business.services;
import java.util.List;

// D: Dto
// E: Entity
public interface IBlogCategoryServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    ///////////////////////////////////////////
    // SPEED DATA Category
    public String categorySpeedData(Integer data);

    // DELETE ALL Category
    public String categoryDeleteAll();

    ///////////////////////////////////////////
    // C R U D
    // CREATE
    public D categoryServiceCreate(D d);

    // LIST
    public List<D> categoryServiceList();

    // FIND BY
    public D categoryServiceFindById(Long id);

    // UPDATE
    public D categoryServiceUpdate(Long id,D d);

    // DELETE
    public D categoryServiceDeleteById(Long id);

} //end interface
