package com.hamitmizrak.runner;

import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.data.repository.IBlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// LOMBOK
@RequiredArgsConstructor
@Log4j2

// Bean
@Configuration
public class BlogCommandLineRunner1 {

    // Injection
    /*
    rol ekle
    register
    email

    * */

    // INJECTION
    // 1.YOL
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final IBlogRepository iBlogRepository ;

    // FIRST
    public void blogCommandLineRunnerAfterBeanMethod(){
        log.info("blog CommandLineRunner After Bean Method başladı");
        System.out.println("blog CommandLineRunner After Bean Method başladı");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Injection
    // CommandLineRunner Metodunu çağırdım
    // Category(1) Blog(N)
    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod() {
        // Lambda Expression
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("Category-Blog CommandLineRunner Çalıştı");
            // Kategoriler Oluştur

            // Tekil Kategori
            BlogCategoryEntity computerCategory=new BlogCategoryEntity();
            computerCategory.setCategoryName("Bilgisayar");
            iBlogCategoryRepository.save(computerCategory);

            // Tekil Kategori
            BlogCategoryEntity tabletCategory=new BlogCategoryEntity();
            tabletCategory.setCategoryName("Tablet");
            iBlogCategoryRepository.save(tabletCategory);

            // Blog-1
            BlogEntity blogEntity=new BlogEntity();
            blogEntity.getBlogEntityEmbeddable().setHeader("Header-1");
            blogEntity.getBlogEntityEmbeddable().setContent("Content-1");
            blogEntity.getBlogEntityEmbeddable().setTitle("Title-1");
            blogEntity.setRelationCategoryEntity(computerCategory);
            iBlogRepository.save(blogEntity);

            // Blog-2
            BlogEntity blogEntity2=new BlogEntity();
            blogEntity2.getBlogEntityEmbeddable().setHeader("Header-2");
            blogEntity2.getBlogEntityEmbeddable().setContent("Content-2");
            blogEntity2.getBlogEntityEmbeddable().setTitle("Title-2");
            blogEntity2.setRelationCategoryEntity(tabletCategory);
            iBlogRepository.save(blogEntity2);
        };
    } //end CommandLineRunner


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //LAST
    public void blogCommandLineRunnerBeforeBeanMethod(){
        log.info("blog CommandLineRunner Before Bean Method bitti");
        System.out.println("blog Command Line Runner Befdre Bean Method bitti");
    }
} //end BlogCommandLineRunner1
