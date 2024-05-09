package com.hamitmizrak.business.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

// LOMBOK
@Data // @Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// @SneakyThrows
// RoleDto(M) RegisterDto(N)

public class EmailDto extends BaseDto implements Serializable {

    // SERILESTIRME
    public static final Long serialVersionUID=1L;

    // Kime
    @NotEmpty(message = "{email.to.validation.constraints.NotNull.message}")
    private String emailTo;

    // Kimden (Gönderen)
    @NotEmpty(message = "{email.from.validation.constraints.NotNull.message}")
    // import org.springframework.beans.factory.annotation.Value;
    @Value("${spring.mail.username}") // application.properties'den gelen veriyi almak
    private String emailFrom;

    // Konu
    @NotEmpty(message = "{email.subject.validation.constraints.NotNull.message}")
    private String emailSubject;

    // İçerik
    @NotEmpty(message = "{email.text.validation.constraints.NotNull.message}")
    private String emailText;

    // CC: public
    private String emailCc;
    //private String[] emailCcArray;

    // BCC: private
    private String emailBcc;
    //private String[] emailBCcArray;

    // Resim
    @Builder.Default
    private String image="image.png";

    // URL
    @Builder.Default
    private String URL="http://localhost:4444/";

} //end Email
