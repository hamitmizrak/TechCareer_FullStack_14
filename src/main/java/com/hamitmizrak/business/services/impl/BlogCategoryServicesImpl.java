package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBeanClass;
import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.business.services.IBlogCategoryServices;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.exception.HamitMizrakException;
import com.hamitmizrak.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class BlogCategoryServicesImpl implements IBlogCategoryServices<BlogCategoryDto, BlogCategoryEntity> {

    // Injection (Field) => 1.YOL
    /*
    @Autowired
    private ICategoryRepository iCategoryRepository;
    */

    // Injection (Constructor Field) => 2.YOL
    /*
    private final ICategoryRepository iCategoryRepository;
    @Autowired
    public CategoryServicesImpl(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }
    */

    // Injection (Lombok Constructor Field) => 3.YOL
    private final IBlogCategoryRepository iCategoryRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    @Transactional
    public String categorySpeedData(Integer data) {
        if (data != null) {
            for (int i = 1; i <= data; i++) {
                BlogCategoryEntity categoryEntity = new BlogCategoryEntity();
                categoryEntity.setCategoryName("category" + i);
                iCategoryRepository.save(categoryEntity);
            }//end for
        } else {
            throw new NullPointerException("Integer have not be null");
        }
        return data + " tane veri yüklendi";
    }

    // DELETE ALL
    @Override
    @Transactional
    public String categoryDeleteAll() {
        iCategoryRepository.deleteAll();
        return "Silindi.";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MODEL MAPPER
    @Override
    public BlogCategoryDto entityToDto(BlogCategoryEntity blogCategoryEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(blogCategoryEntity, BlogCategoryDto.class);
    }

    @Override
    public BlogCategoryEntity dtoToEntity(BlogCategoryDto categoryDto) {
        return modelMapperBeanClass.modelMapperMethod().map(categoryDto, BlogCategoryEntity.class);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    @Override
    @Transactional // create, delete, update
    public BlogCategoryDto categoryServiceCreate(BlogCategoryDto blogCategoryDto) {
        if (blogCategoryDto != null) {
            BlogCategoryEntity categoryEntity = dtoToEntity(blogCategoryDto);
            iCategoryRepository.save(categoryEntity);
            blogCategoryDto.setCategoryId(categoryEntity.getCategoryId());
            blogCategoryDto.setSystemCreatedDate(categoryEntity.getSystemCreatedDate());
        } else {
            throw new NullPointerException(" CategoryDto null veri");
        }
        return blogCategoryDto;
    }

    // LIST
    @Override
    public List<BlogCategoryDto> categoryServiceList() {
        Iterable<BlogCategoryEntity> entityIterable = iCategoryRepository.findAll();
        // Dto To entityb List
        List<BlogCategoryDto> categoryDtoList = new ArrayList<>();
        for (BlogCategoryEntity entity : entityIterable) {
            BlogCategoryDto categoryDto = entityToDto(entity);
            categoryDtoList.add(categoryDto);
        }
        log.info("Liste Sayısı: " + categoryDtoList.size());
        return categoryDtoList;
    }

    // FIND
    @Override
    public BlogCategoryDto categoryServiceFindById(Long id) {
        // 1.YOL (FIND)
        /*
        Optional<CategoryEntity> findOptionalCategoryEntity=  iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDto(findOptionalCategoryEntity.get());
        if(findOptionalCategoryEntity.isPresent()){
            return categoryDto;
        }
        */

        // 2.YOL (FIND)
        BlogCategoryEntity findCategoryEntity = null;
        if (id != null) {
            findCategoryEntity = iCategoryRepository.findById(id)
                    .orElseThrow(() -> new Resource404NotFoundException(id + " nolu id yoktur"));
        } else if (id == null) {
            throw new HamitMizrakException("İd null olarak geldi");
        }
        return entityToDto(findCategoryEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public BlogCategoryDto categoryServiceUpdate(Long id, BlogCategoryDto categoryDto) {
        // Önce Bul
        BlogCategoryDto categoryFindDto = categoryServiceFindById(id);
        if (categoryFindDto != null) {
            BlogCategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            categoryEntity.setCategoryName(categoryDto.getCategoryName());
            iCategoryRepository.save(categoryEntity);
            // Dönüştede ID ve Date Set et
        }
        return categoryDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public BlogCategoryDto categoryServiceDeleteById(Long id) {
        // Önce Bul
        BlogCategoryDto categoryFindDto = categoryServiceFindById(id);
        if (categoryFindDto != null) {
            iCategoryRepository.deleteById(id);
            // Dönüştede ID ve Date Set et
        }
        return categoryFindDto;
    }


} //end class
