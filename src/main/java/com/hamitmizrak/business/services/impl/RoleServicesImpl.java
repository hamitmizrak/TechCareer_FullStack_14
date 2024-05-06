package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.business.dto.RoleDto;
import com.hamitmizrak.business.services.IRoleService;
import com.hamitmizrak.data.entity.RoleEntity;

import java.util.List;

public class RoleServicesImpl implements IRoleService<RoleDto, RoleEntity> {


    @Override
    public RoleDto entityToDto(RoleEntity roleEntity) {
        return null;
    }

    @Override
    public RoleEntity dtoToEntity(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto roleServiceCreate(RoleDto roleDto) {
        return null;
    }

    @Override
    public List<RoleDto> roleServiceList(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto roleServiceFindById(Long id) {
        return null;
    }

    @Override
    public RoleDto roleServiceUpdateById(Long id, RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto roleServiceDeleteById(Long id) {
        return null;
    }
}
