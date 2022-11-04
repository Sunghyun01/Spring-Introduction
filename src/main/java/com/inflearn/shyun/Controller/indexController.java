package com.inflearn.shyun.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
	
	@GetMapping("hello")
	public String hello (Model model) {
		model.addAttribute("data","hello!!");
		return "hello";
	}
	
	@GetMapping("mvc")
	public String mvc (@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name",name);
		
		return "mvc";
	}
	
	@GetMapping("string")
	@ResponseBody // body 부분에 아래 내용을 넣어줌
	//API 방식
	public String string (@RequestParam(value = "name", required = false) String name) {

		return "ㅁㄴㅇㄻㄴㅇㄹ";
	}
	
	@GetMapping("api")
	@ResponseBody // body 부분에 아래 내용을 넣어줌
	public Hello helloapi(@RequestParam(value = "name", required = false) String name) {
		Hello hello = new Hello();
		hello.setName(name);
		
		return hello;
	}
	
	static class Hello {
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
