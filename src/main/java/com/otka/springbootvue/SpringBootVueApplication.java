package com.otka.springbootvue;

import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(TodoRepository repository) {
	    return args -> {
	        Stream.of("Buy milk", "Eat pizza", "Write turtorial", "Study Vue.js", "Go Kayaking").forEach(name -> {
	              Todo todo = new Todo();
	              todo.setTitle(name);
	              repository.save(todo);
	        });
	        repository.findAll().forEach(System.out::println);
	    };
	}
	
	@Bean
	public FilterRegistrationBean SimpleCorsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials( true );
	    config.setAllowedOrigins(Collections.singletonList( "http://localhost:8080" ));
	    config.setAllowedMethods( Collections.singletonList("*"));
	    config.setAllowedHeaders(Collections.singletonList( "*" ));
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder( Ordered.HIGHEST_PRECEDENCE );
	    return bean;
	    
	  
	           
	}
}
