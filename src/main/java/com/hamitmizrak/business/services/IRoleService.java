package com.hamitmizrak.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IRoleService<D, E> {

    // MODEL MAPPER
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    ////////////////////////////////////////////
    // ROLE CRUD

    // CREATE Role(Service)
    public D roleServiceCreate(D d);

    // LIST Role(Service)
    public List<D> roleServiceList();

    // FIND BY-ID Role(Service)
    public D roleServiceFindById(Long id);

    // UPDATE Role(Service)
    public D roleServiceUpdateById(Long id, D d);

    // DELETE Role(Service)
    public D roleServiceDeleteById(Long id);
}// end IRoleService
