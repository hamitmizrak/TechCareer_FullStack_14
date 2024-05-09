package com.hamitmizrak.tokenmail;

// Generics
public interface IForRegisterTokenEmailConfirmationServices<T> {

    // CREATE (TOKEN)
    public String createToken(T t);

    // DELETE (TOKEN)
    public void deleteToken(Long id);
}
