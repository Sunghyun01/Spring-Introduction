package com.inflearn.shyun.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
