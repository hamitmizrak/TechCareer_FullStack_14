package com.hamitmizrak.role;

// final verirsem;
// 1-) Değişkende: sabit değer
// 2-) Metotda: Override edilemez
// 3-) Classta: Kalıtımlanamaz, edilemez

// 1-) Değişkende final verirsek;
// 1-a_) Değeri sabit yapar.
// 2-a_) Sadece Get metodunu eklemeye yarar
// 3-a_) Bizi Constructur yazmamıza zorlar
public enum ERole {
    ADMIN(2L,"admin") ,
    ACCOUNTING(3L,"accounting") ,
    WRITER(4L,"writer") ,
    USER(5L,"user");

    // variable
    private final Long key;
    private final String value;

    // Constructor (Parametreli constructor)
    // Constructor'a private verirsek;
    // Bu Enum'ın instance(new) oluşturulmasına izin vermiyor.
    private ERole(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    // GETTER
    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
} //end Enum ERoles
