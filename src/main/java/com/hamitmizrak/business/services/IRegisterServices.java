package com.hamitmizrak.business.services;

import java.util.List;

/*
 Register başlangıçta pasif durumda;
 1- Ancak mail onaylanmasıyla aktifleşecek.
 2- SMS pin code:
*/

// Register(N) Roles(M)
public interface IRegisterServices<D, E> {

    // MODEL MAPPER
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    ////////////////////////////////////////////
    // SPEED DATA
    public String registerSpeedData(Long data);

    // USER ALL DELETE
    public String registerAllUSerDelete();

    ////////////////////////////////////////////
    // REGISTER CRUD

    // CREATE Register(Service)
    public D registerServiceCreate(Long rolesId, D d);

    // LIST Register(Service)
    public List<D> registerServiceList();

    // FIND BY-ID Register(Service)
    public D registerServiceFindById(Long id);

    // UPDATE Register(Service)
    public D registerServiceUpdateById(Long id, D d);

    // DELETE Register(Service)
    public D registerServiceDeleteById(Long id);

    ////////////////////////////////////////////////
    // EMAIL CONFIRMATION - TOKEN
}// end IRegisterService
