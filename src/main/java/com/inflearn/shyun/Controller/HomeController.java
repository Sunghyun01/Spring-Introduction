package com.inflearn.shyun.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/h2")
    public String home() {

        return "home";
    }
}
