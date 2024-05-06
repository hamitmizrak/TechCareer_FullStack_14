package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBeanClass;
import com.hamitmizrak.business.dto.RoleDto;
import com.hamitmizrak.business.services.IRoleService;
import com.hamitmizrak.data.entity.RoleEntity;
import com.hamitmizrak.data.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Lombok
@RequiredArgsConstructor
@Log4j2

// Service: Asıl İş Yükünü sırtlayan
@Service
@Component("roleServicesImpl") // @Component => Spring'in bir parcasısın
public class RoleServicesImpl implements IRoleService<RoleDto, RoleEntity> {

    // Injection IRoleRepository (1.YOL => @Autowired)
    /*
    @Autowired
    private IRoleRepository iRoleRepository;
    */

    // Injection IRoleRepository (2.YOL => Constructor Injection)
    /*
    private final IRoleRepository iRoleRepository;
    @Autowired
    public RoleServicesImpl(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }
    */

    // 3. YOL (Lombok => Constructor Injection)
    private final IRoleRepository iRoleRepository;

    // 1.YOL (ModelMapper)
    // private final ModelMapper modelMapper;
    private final ModelMapperBeanClass modelMapperBeanClass;

    ///////////////////////////////////////////////////////////////////////////////////////
    //**** Model Mapper *****************************************************************//
    // Model Mapper
    @Override
    public RoleDto entityToDto(RoleEntity roleEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(roleEntity,RoleDto.class);
    }

    @Override
    public RoleEntity dtoToEntity(RoleDto roleDto) {
        return modelMapperBeanClass.modelMapperMethod().map(roleDto, RoleEntity.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //**** CRUD*****************************************************************//
    // Create
    @Override
    public RoleDto roleServiceCreate(RoleDto roleDto) {
        RoleEntity roleEntity1;
        // Dto => Entity çevirmek
        roleEntity1=dtoToEntity(roleDto);
        roleEntity1.setRoleName(roleEntity1.getRoleName().toUpperCase());
        // Kaydetmek
        RoleEntity roleEntity2=iRoleRepository.save(roleEntity1);
        // ID ve Date Dto üzerinde Set yapıyorum
        roleDto.setRoleId(roleEntity2.getRoleId());
        roleDto.setSystemCreatedDate(roleEntity2.getSystemCreatedDate());
        return roleDto;
    } //end Create

    // List
    @Override
    public List<RoleDto> roleServiceList(RoleDto roleDto) {
        //Entity List
        List<RoleEntity> roleEntityList1=iRoleRepository.findAll();

        // Dto List
        List<RoleDto> roleDtoList=new ArrayList<>();

        // Entity To Dto List
        for(RoleEntity tempEntity:roleEntityList1){
            RoleDto roleDto1=entityToDto(tempEntity);
            roleDtoList.add(roleDto1);
        }
        return roleDtoList;
    }

    // Find
    @Override
    public RoleDto roleServiceFindById(Long id) {
        return null;
    }

    // Update
    @Override
    public RoleDto roleServiceUpdateById(Long id, RoleDto roleDto) {
        return null;
    }

    // Delete
    @Override
    public RoleDto roleServiceDeleteById(Long id) {
        return null;
    }

} //end RoleServicesImpl
