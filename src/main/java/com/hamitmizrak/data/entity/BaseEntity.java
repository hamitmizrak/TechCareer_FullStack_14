package com.hamitmizrak.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
@ToString

// abstract Class
@MappedSuperclass
@JsonIgnoreProperties(value = {},allowGetters = true) // Json, burada verdiğim özellikleri takip etme
abstract public class BaseEntity  extends AuditingAwareBaseEntity implements Serializable {

    // SERILESTIRME
    public static final Long serialVersionUID = 1L;

    // Role ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    // System Created Date
    @Builder.Default
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "system_created_date")
    protected Date systemCreatedDate=new Date(System.currentTimeMillis());

} //end BaseEntity
