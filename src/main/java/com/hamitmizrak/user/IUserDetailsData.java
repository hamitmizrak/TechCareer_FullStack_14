package com.hamitmizrak.user;

public interface IUserDetailsData {

    // Kullanıcı register olduktan sonra Mail göndersin ve kullanıcı aktif etsin
    // USER DETAILS

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default
    Boolean isAccountNonLocked(Boolean result);

    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    Boolean isAccountNonExpired(Boolean result);

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    Boolean isCredentialsNonExpired(Boolean result);

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    Boolean isEnabled(Boolean result);
}
