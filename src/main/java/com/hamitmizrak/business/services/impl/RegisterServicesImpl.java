package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBeanClass;
import com.hamitmizrak.bean.PasswordEncoderBeanClass;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterServices;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.entity.RoleEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import com.hamitmizrak.data.repository.IRoleRepository;
import com.hamitmizrak.exception.HamitMizrakException;
import com.hamitmizrak.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Lombok
@RequiredArgsConstructor
@Log4j2

// Service: Asıl İş Yükünü sırtlayan
@Service
@Component("registerServicesImpl") // @Component => Spring'in bir parcasısın
public class RegisterServicesImpl implements IRegisterServices<RegisterDto, RegisterEntity> {

    // Injection
    private final IRoleRepository iRoleRepository;
    private final IRegisterRepository iRegisterRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;
    private final PasswordEncoderBeanClass passwordEncoderBeanClass;


    ///////////////////////////////////////////////////////////////////////////////////////
    //**** Model Mapper *****************************************************************//
    // Model Mapper
    @Override
    public RegisterDto entityToDto(RegisterEntity registerEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(registerEntity, RegisterDto.class);
    }

    @Override
    public RegisterEntity dtoToEntity(RegisterDto registerDto) {
        return modelMapperBeanClass.modelMapperMethod().map(registerDto, RegisterEntity.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //**** Speed Data And User All Delete ****************************************************//
    // Speed Data
    @Override
    @Transactional// Create,Update,Delete
    public String registerSpeedData(Long data) {
        // Eğer data boş değilse Ekleme yapsın
        if(data!=null){
            RegisterDto registerDto=new RegisterDto();
            registerDto.setRegisterNickName("nickname");
            registerDto.setRegisterName("name");
            registerDto.setRegisterSurname("surname");
            registerDto.setRegisterPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode("1234"));
            registerDto.setRegisterEmail("hamitmizrak@gmail.com");
            registerDto.setIsAccountNonLocked(false); //mail ile aktifleşitreceğim.
            registerDto.setIsEnabled(true);
            registerDto.setIsAccountNonExpired(true);
            registerDto.setIsCredentialsNonExpired(true);

            // Model Mapper

            RegisterEntity registerEntity=dtoToEntity(registerDto);
            iRegisterRepository.save(registerEntity);

            // ID ve Date Dto üzerinde Set yapıyorum
            registerDto.setRegisterId(registerEntity.getRegisterId());
            registerDto.setSystemCreatedDate(registerEntity.getSystemCreatedDate());
            return data+" tane veri eklendi\nEklenen Veri"+registerDto;
        }
        return null;
    }

    // User All Delete
    @Override
    @Transactional// Create,Update,Delete
    public String registerAllUSerDelete() {
        iRegisterRepository.deleteAll();
        String information=registerServiceList().size()+" tane veri silindi";
        log.info(information);
        return information;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //**** CRUD ****************************************************//
    // CREATE (REGISTER)
    // ROLE AND REGISTER
    @Override
    @Transactional// Create,Update,Delete
    public RegisterDto registerServiceCreate(Long rolesId, RegisterDto registerDto) {

        // Eğer RegisterDto boş değilse Ekleme yapsın
        if(registerDto!=null && iRoleRepository.findAll().size()!=0){
            // Model Mapper
            RegisterEntity registerEntity=dtoToEntity(registerDto);

            // Masking Password
            registerEntity.setRegisterPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode(registerDto.getRegisterPassword()));

            // Önce Rolü Eklemelisiniz.
            int roleIdMatch= Integer.valueOf(Math.toIntExact(rolesId));
            RoleEntity roleEntity=iRoleRepository.findAll().get(roleIdMatch-1);
            Set<RoleEntity> roleEntitySet=new HashSet<>();
            roleEntitySet.add(roleEntity);
            registerEntity.setRoles(roleEntitySet);

            // SAVE
            iRegisterRepository.save(registerEntity);

            // ID ve Date Dto üzerinde Set yapıyorum
            registerDto.setRegisterId(registerEntity.getRegisterId());
            registerDto.setSystemCreatedDate(registerEntity.getSystemCreatedDate());
            return registerDto;
        }
        return null;
    }

    // LIST (REGISTER)
    @Override
    public List<RegisterDto> registerServiceList() {
       Iterable<RegisterEntity> registerEntityIterable= iRegisterRepository.findAll();

       // DTO (LIST)
        List<RegisterDto> registerDtoList=new ArrayList<>();

        // ForEach Loop
        for(RegisterEntity temp: registerEntityIterable){
            registerDtoList.add(entityToDto(temp));
        }
        log.info("Register Liste sayısı: "+registerDtoList.size());
        return registerDtoList;
    }

    // FIND BY ID (REGISTER)
    @Override
    public RegisterDto registerServiceFindById(Long id) {
        // Öncelikle ilgili ID sistemde var mı yok mu kontrolünü sağlıyorum.
        Boolean booleanRegisterEntityFindById = iRegisterRepository.findById(id).isPresent();
        RegisterEntity registerEntity= null;
        if (booleanRegisterEntityFindById) {
            registerEntity = iRegisterRepository.findById(id).orElseThrow(
                    () -> new Resource404NotFoundException(id + " nolu ID Bulunamadı")
            );
        } else if (!booleanRegisterEntityFindById) {
            throw new HamitMizrakException("Roles Dto id boş değer geldi");
        }
        return entityToDto(registerEntity);
    }

    // UPDATE (REGISTER)
    // ROLEID AND REGISTER
    @Override
    @Transactional// Create,Update,Delete
    public RegisterDto registerServiceUpdateById(Long id, RegisterDto registerDto) {
        // Eğer registerDto boş değilse
        if(registerDto!=null){
            RegisterEntity registerEntity=new RegisterEntity();
            registerEntity.setRegisterNickName(registerDto.getRegisterNickName());
            registerEntity.setRegisterName(registerDto.getRegisterName());
            registerEntity.setRegisterSurname(registerDto.getRegisterSurname());
            registerEntity.setRegisterEmail(registerDto.getRegisterEmail());
            registerEntity.setRegisterPassword(registerDto.getRegisterPassword());
            // Rol Değiştirmek istiyorsan bununda otocaontrolünü yapmalısın ????
            iRegisterRepository.save(registerEntity);
            return entityToDto(registerEntity);
        }
        return null;
    }

    // DELETE BY ID (REGISTER)
    @Override
    @Transactional// Create,Update,Delete
    public RegisterDto registerServiceDeleteById(Long id) {
        RegisterDto registerFindDto=registerServiceFindById(id);
        if(registerFindDto!=null){
            iRegisterRepository.deleteById(id);
        }
        return registerFindDto;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //**** EMAIL TOKEN ****************************************************//

} //end RegisterImpl
