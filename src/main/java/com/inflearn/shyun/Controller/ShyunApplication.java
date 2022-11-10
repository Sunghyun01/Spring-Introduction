package com.inflearn.shyun.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"../service/MemberService"})
// 스프링 실행시 해당 서비스를 불러오지 못해서 추가
public class ShyunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShyunApplication.class, args);
	}

}
