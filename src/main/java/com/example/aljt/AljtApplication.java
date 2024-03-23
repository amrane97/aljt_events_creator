package com.example.aljt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.aljt.repositorie", "other.package.if.any"})
public class AljtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AljtApplication.class, args);
	}

}
