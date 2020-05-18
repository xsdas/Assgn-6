package com.stackroute.newz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.newz.zuul.filter.JwtFilter;

/*
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration 
 * and @ComponentScan with their default attributes
 * 
 * Add @EnableZuulProxy and @EnableEurekaClient
 * 
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class NewzNetflixZuulApiGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewzNetflixZuulApiGatwayApplication.class, args);
	}

	/*
	 * Define the bean for Filter registration. Create a new FilterRegistrationBean
	 * object and use setFilter() method to set new instance of JwtFilter object.
	 * Also specifies the Url patterns for registration bean.
	 */

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		final FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<JwtFilter>();
		filterRegistrationBean.setFilter(new JwtFilter());
//		filterRegistrationBean.addUrlPatterns("/NewsService/api/v1/news/*", "/AuthenticationService/api/v1/auth/*",
//				"/NewsSourceService/api/v1/newssource/*", "/UserProfileService/api/v1/user/*");
		filterRegistrationBean.addUrlPatterns("/AuthenticationService/api/v1/auth/*");
		return filterRegistrationBean;

	}

}
