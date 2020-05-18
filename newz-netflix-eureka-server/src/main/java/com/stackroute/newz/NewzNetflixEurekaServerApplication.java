package com.stackroute.newz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration 
 * and @ComponentScan with their default attributes
 * 
 * Add @EnableEurekaServer
 * @EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })
 */
@SpringBootApplication
@EnableEurekaServer
public class NewzNetflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewzNetflixEurekaServerApplication.class, args);
	}
}
