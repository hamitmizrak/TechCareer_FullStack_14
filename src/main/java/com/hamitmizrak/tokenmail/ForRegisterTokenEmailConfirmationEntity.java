package com.hamitmizrak.tokenmail;

import com.hamitmizrak.data.entity.BaseEntity;
import com.hamitmizrak.data.entity.RegisterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

// LOMBOK
@Data
@AllArgsConstructor
@Builder
@Log4j2
// @SneakyThrows

// EMAIL
@Entity(name = "ConfirmationTokens") // Sql JOIN için yazdım
@Table(name = "confirmationToken")
// 1(TokenEntity) - 1(RegisterEntity)
public class ForRegisterTokenEmailConfirmationEntity extends BaseEntity {

    // TOKEN
    private String token;

    // CONSTRUCTOR PARAMETRESIZ
    public ForRegisterTokenEmailConfirmationEntity() {}

    // CONSTRUCTOR PARAMETRELI  (1-1) için UserEntity eklemelisinnnnnn.
    public ForRegisterTokenEmailConfirmationEntity(RegisterEntity registerEntity) {
        this.registerEntity = registerEntity;// Null Pointer Exception almamak için
        this.token= UUID.randomUUID().toString(); //benzersiz bir unique oluştur.
    }

    // @OneToOne (1-1)
    // Her kullanıcın 1 tane tokeni olmalıdır.
    @OneToOne(targetEntity =RegisterEntity.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="register_id")
    private RegisterEntity registerEntity;

}// end class
