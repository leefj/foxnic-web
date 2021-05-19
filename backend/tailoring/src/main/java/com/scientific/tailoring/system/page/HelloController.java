package com.scientific.tailoring.system.page;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.system.service.ILangService;

@Controller
public class HelloController {
 
    @RequestMapping("/hello.html")
    public String hello(Model model,HttpServletRequest request) {
        model.addAttribute("name", "thymeleaf");
        return "hello";
    }
    
    
    
}