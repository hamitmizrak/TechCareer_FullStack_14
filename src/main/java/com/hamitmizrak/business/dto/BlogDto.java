package com.hamitmizrak.business.dto;


import com.hamitmizrak.audit.AuditingAwareBaseDto;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// Validation
// BlogDto(N) BlogCategory(1)
public class BlogDto extends AuditingAwareBaseDto implements Serializable {

    // serileştirme
    public static final Long serialVersionUID=1L;

    // NOT: ID ayrıca yazdım çünkü relationda sıkıntı olabiliyor.
    // ID
    private Long blogId;

    // DATE
    @Builder.Default
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    // HEADER
    @NotEmpty(message ="{blog.header.validation.constraints.NotNull.message}")
    @Size(min=10,message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String header;

    // CONTENT
    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min = 10,message = "{blog.content.least.validation.constraints.NotNull.message}")
    @Lob
    private String content;

    // TITLE
    @NotEmpty(message = "{blog.title.validation.constraints.NotNull.message}")
    @Size(min = 5,message = "{blog.title.least.validation.constraints.NotNull.message}")
    private String title;

    // IMAGE
    @NotEmpty(message = "{blog.title.validation.constraints.NotNull.message}")
    @Builder.Default
    private String image="resim.png";

} //end class
