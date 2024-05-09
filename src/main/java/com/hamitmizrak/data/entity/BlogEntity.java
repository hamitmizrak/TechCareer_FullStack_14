package com.hamitmizrak.data.entity;


import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import com.hamitmizrak.data.embedded.EmbeddableBlogEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@Builder
@Log4j2

// ENTITY
@Entity(name = "Blogs") // Sql JOIN için yazdım
@Table(name = "blog")

// Blog(N)  Category(1)
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long blogId;

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;

    // Embedded
    @Embedded
    private EmbeddableBlogEntity blogEntityEmbeddable=new EmbeddableBlogEntity();

    //  RELATION
    // Blog(N)  Category(1)
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    private BlogCategoryEntity relationCategoryEntity;

    // Constructor (Parametresiz)
    public BlogEntity() {
    }

    // Constructor (Parametreli)
    public BlogEntity(EmbeddableBlogEntity embeddableBlogEntity, BlogCategoryEntity relationBlogCategoryEntity) {
        this.blogEntityEmbeddable = embeddableBlogEntity;
        this.relationCategoryEntity = relationBlogCategoryEntity;
    }
} //end class
