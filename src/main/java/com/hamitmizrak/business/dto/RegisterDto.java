package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotation.AnnotationUniqueEmailAddress;
import com.hamitmizrak.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

// LOMBOK
@Data // @Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// @SneakyThrows
// RoleDto(M) RegisterDto(N)

// NOT: Validation işlemlerinde DTO tarafında yazalım.
// NOT: Eğer kullanıcı boşluk bıraktıysa trim() metotudunu kullanın

// REGISTER
public class RegisterDto extends AuditingAwareBaseDto implements Serializable {

    // Serilestirme
    public static final Long serialVersionUID=1L;

    // Register ID
    private Long registerId;

    // System Created Date
    private Date systemCreatedDate;

    /////////////////////////////////////////////////////////////////////////////////
    // Nickname
    @NotEmpty(message = "{register.nickname.validation.constraints.NotNull.message}")
    private String registerNickName;

    // Name
    @NotEmpty(message = "{register.name.validation.constraints.NotNull.message}")
    private String registerName;

    // Surname
    @NotEmpty(message = "{register.surname.validation.constraints.NotNull.message}")
    private String registerSurname;

    // Email
    @NotEmpty(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.regex.message}")
    @AnnotationUniqueEmailAddress // have to unique email address
    private String registerEmail;

    // Password
    // Java12345@.
    @NotEmpty(message = "{register.password.validation.constraints.NotNull.message}")
    @Size(min = 7,max=15,  message = "{register.password.validation.constraints.MinMax.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", message = "{register.password.pattern.validation.constraints.NotNull.message}")
    private String registerPassword;

    // Page Authorization (O kişi o sayfaya yetkisi var mı
    @Builder.Default
    private Boolean pageAuthorization=false;

    // Rolles (Enum)
    private Collection<RoleDto> roles;

    /////////////////////////////////////////////////////////////////////////////////
    // USER DETAILS
    // Kullanıcı üye olurken kilitli olsun ancak mail onayı ile aktifleştirilsin
    public Boolean isAccountNonLocked;

    // Kullanıcı hesabını pasit duruma getirme
    public Boolean isAccountNonExpired;

    // Kullanıcı Hesap Bilgi Süresi (Authorization)
    public Boolean isCredentialsNonExpired;

    // Kullanıcı Sistemde mi ?
    public Boolean isEnabled;

    /////////////////////////////////////////////////////////////////////////////////
    // PARAMETRESIZ CONSTRUCTOR
    // PARAMETRELI CONSTRUCTOR
    // TOSTRING

} //end RegisterDto
