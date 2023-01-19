package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping("/")//localhost:8080를 주소창에 치면 retun 값인 home.html로간다
    //만약에 괄호안에 "youngjin"을 하면 localhost:8080/youngjin을 쳐야 home.html로가진다
    public String home(){
        return "home";
    }
}