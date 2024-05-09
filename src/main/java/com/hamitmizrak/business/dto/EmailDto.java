package com.hamitmizrak.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
    private String emailTo;

    // Kimden
    private String emailFrom;

    // Konu
    private String emailSubject;

    // İçerik
    private String emailText;

    // CC: public
    private String emailCc;
    private String[] emailCcArray;

    // BCC: private
    private String emailBcc;
    private String[] emailBCcArray;

    // Resim
    @Builder.Default
    private String image="image.png";

    // URL
    @Builder.Default
    private String URL="http://localhost:4444/";

} //end Email
