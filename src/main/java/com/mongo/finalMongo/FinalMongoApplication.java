package com.mongo.finalMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class FinalMongoApplication {
	public static void main(String[] args) {SpringApplication.run(FinalMongoApplication.class, args);}

}
