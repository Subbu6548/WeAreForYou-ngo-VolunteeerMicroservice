package com.fsd.volunteermicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class VolunteerMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolunteerMicroservicesApplication.class, args);
	}

}