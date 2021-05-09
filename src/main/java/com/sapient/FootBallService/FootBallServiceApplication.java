package com.sapient.FootBallService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class FootBallServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FootBallServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Bean
	public RestTemplate restTemplate(){
		/*HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(); 
		factory.setConnectTimeout(3000);   // Added timeout for each request
        return new RestTemplate(factory);*/ 
		return new RestTemplate();
	}
}
