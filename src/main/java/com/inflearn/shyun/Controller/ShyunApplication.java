package com.inflearn.shyun.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"../service/MemberService"})
public class ShyunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShyunApplication.class, args);
	}

}
