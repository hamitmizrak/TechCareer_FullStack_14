package com.hamitmizrak.business.services;

// D: Dto
// E: Entity

import com.hamitmizrak.business.dto.EmailDto;

// Email
public interface IEmailServices<D, E> {

    // MODEL MAPPER
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    ////////////////////////////////////////////
    // Maili Öncelikle Database kaydedelim.
    public D mailDatabase(D d);


    ///////////////////////////////////////////////////////////////////////////////////////
    //**** EMAIL DATABASE *****************************************************************//
    // Email Database
    EmailDto mailDatabase(EmailDto emailDto);

    ////////////////////////////////////////////
    // EMAIL BASIC SEND (text)
    public D basicSendEmail(D d);

    // EMAIL INTERMEDIA ATTACHMENT SEND (image,word,text,files)
    public D intermediaSendEmail(D d);

}// end IRegisterService
