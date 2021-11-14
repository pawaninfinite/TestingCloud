package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CorsFilter  corsFilter() {
		
		CorsConfiguration corsConfiguration=new CorsConfiguration();
		
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Content-Type"
				,"Accept","Authorization","Origin, Accept","X-Requested-With","Access-Control-Allow-Origin",
				"Access-Control-Request-Method","Access-Control-Request-Header"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type"
				,"Accept","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Creadentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("Get","Post"
				,"Put","Delete",
				"OPTIONS"));
		
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("**/**", corsConfiguration);
		
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	

}
