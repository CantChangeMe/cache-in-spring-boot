package com.vivek.spring.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //It will enable caching functionality
public class CachingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingSpringBootApplication.class, args);
	}

}
