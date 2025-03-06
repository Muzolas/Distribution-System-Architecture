package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
 * 
 *  Spring Boot uygulamasını başlatan ana sınıftır ve uygulamada önbellekleme (caching) özelliğini etkinleştirir.
 * 
*/
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
} 