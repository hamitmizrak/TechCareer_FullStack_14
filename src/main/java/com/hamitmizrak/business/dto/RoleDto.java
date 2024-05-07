package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotation.AnnotationUniqueRoleName;
import com.hamitmizrak.audit.AuditingAwareBaseDto;
import com.hamitmizrak.role.ERole;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data // @Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// @SneakyThrows
// RoleDto(M) RegisterDto(N)
public class RoleDto extends AuditingAwareBaseDto implements Serializable {

    // SERILESTIRME
    public static final Long serialVersionUID=1L;

    // Role ID
    private Long roleId;

    // Role Name
    // Validation
    @NotEmpty(message = "{role.name.validation.constraints.NotNull.message}")
    // Annotation kullanmalısın cunku database aynı role adında olmaması gerekiyor (unique)
    @AnnotationUniqueRoleName
    @Builder.Default
    private String roleName= ERole.USER.toString();

    // System Created Date
    private Date systemCreatedDate;
} //end class RoleDto
