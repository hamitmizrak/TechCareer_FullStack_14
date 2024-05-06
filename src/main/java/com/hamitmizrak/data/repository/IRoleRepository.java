package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// CrudRepository<RoleEntity,Long>
// JpaRepository<RoleEntity,Long>
// PagingAndSortingRepository<RoleEntity,Long>

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

    // Delivered Query (database query
    // Database Role Name bulmak
    // select * from Roles as rol where rol.role_name
    Optional<RoleEntity> findByRoleName(String roleName);

} //end interface
