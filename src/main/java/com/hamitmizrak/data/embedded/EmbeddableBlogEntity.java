package com.hamitmizrak.data.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

@Embeddable
public class EmbeddableBlogEntity {

    // HEADER
    @Column(
            name = "header",
            nullable = false,
            unique = true,
            length = 500,
            insertable = true,
            updatable = true,
            columnDefinition = "varchar(255) default 'blog için başlık girilmedi'")
    private String header;

    // CONTENT
    @Lob
    @Column(name = "content", columnDefinition = "varchar(255) default 'blog için içerik girilmedi'")
    private String content;

    // TITLE
    private String title;

    // IMAGE
    private String image;

   /*
   Javada olsun Database(Entity) olmasının
   @Transient
    private Object specialData;
    */
}
