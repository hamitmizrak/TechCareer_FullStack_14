package com.hamitmizrak.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//LOMBOK
@Getter
@Setter

// abstract CLASS
abstract public class AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // AUDITING
    // Kim ekledi
    // @JsonIgnore // Backte giden veride bunu göstermemek için kullanılır.
    protected String createdUser;

    // Kim ne zaman ekledi
    // @JsonIgnore // Backte giden veride bunu göstermemek için kullanılır.
    protected Date createdDate;

    // Kim güncelledi
    // @JsonIgnore // Backte giden veride bunu göstermemek için kullanılır.
    protected String lastUser;

    // Kim ne zaman güncelledi
    // @JsonIgnore // Backte giden veride bunu göstermemek için kullanılır.
    protected Date lastDate;

} //end class
