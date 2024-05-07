package com.hamitmizrak.data.entity;

import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import com.hamitmizrak.data.embedded.EmbeddableUserDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// LOMBOK
@Data // @Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
//@SneakyThrows
// RoleDto

// ENTITY
@Entity(name = "Registers")
@Table(name = "registers")
// Role(M) Register(N)
public class RegisterEntity extends AuditingAwareBaseEntity implements Serializable {

    // SERILESTIRME
    public static final Long serialVersionUID = 1L;

    // Role ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Long registerId;


    // System Created Date
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;

    // Nickname
    @Column(name = "nick_name")
    private String nickName;

    // Name
    @Column(name = "name")
    private String name;

    // Surname
    @Column(name = "surname")
    private String surname;

    // Email
    @Column(
            name = "register_email",
            nullable = false,
            updatable = false,
            insertable = true,
            length = 60,
            columnDefinition = "varchar(255) default 'hamitmizrak@gmail.com'")
    private String registerEmail;

    // Password
    @Column(name = "password")
    private String password;

    // Page Authorization (O kişi o sayfaya yetkisi var mı
    @Column(name = "page_authorization")
    private Boolean pageAuthorization = false;

    /////////////////////////////////////////////
    // Relation
    // Rolles (Enum)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "register_roles",
            joinColumns = @JoinColumn(name = "register_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

    /////////////////////////////////////////////
    // USER DETAILS
    // @Embedable
    // @Embedded
    // @EmbeddedId
    @Embedded
    private EmbeddableUserDetails embeddableUserDetails = new EmbeddableUserDetails();
}// end RegisterEntity
