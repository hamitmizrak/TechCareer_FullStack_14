package com.hamitmizrak.business.dto;

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
//@SneakyThrows
// RoleDto
public class RoleDto implements Serializable {

    // Role ID
    private Long roleId;

    // Role Name
    // Validation
    @NotEmpty(message = "{role.name.validation.constraints.NotNull.message}")
    private String roleName;

    // System Created Date
    private Date systemCreatedDate;
} //end class RoleDto
