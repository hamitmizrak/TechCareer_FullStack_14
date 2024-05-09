package com.hamitmizrak.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IBlogServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    public String blogSpeedData(Long data);

    // ALL DELETE
    public String blogAllDelete();

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // C R U D
    // CREATE
    public D blogServiceCreate(D d);

    // LIST
    public List<D> blogServiceList();

    // FIND BY
    public D blogServiceFindById(Long id);

    // UPDATE
    public D blogServiceUpdate(Long id,D d);

    // DELETE
    public D blogServiceDeleteById(Long id);
}
