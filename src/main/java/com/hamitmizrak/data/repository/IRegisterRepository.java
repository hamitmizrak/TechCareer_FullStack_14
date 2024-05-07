package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.RegisterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// CrudRepository<RoleEntity,Long>
// JpaRepository<RoleEntity,Long>
// PagingAndSortingRepository<RoleEntity,Long>

@Repository
public interface IRegisterRepository extends CrudRepository<RegisterEntity,Long> {

    // Delivered Query (database query
    // Database Role Name bulmak
    // select * from Roles as rol where rol.role_name
    Optional<RegisterEntity> findByRegisterEmail(String email);

    // Query: Karmaşık sorgular için @Qery kullanıyoruz
    @Query("select reg from Registers reg join reg.roles rol where rol.roleName=:roleNameParam")
    List<RegisterEntity> findAllByRegisterInJoinRolesRoleName(@Param("roleNameParam") String roleName );


} //end interface