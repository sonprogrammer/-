package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.font.EAttribute;
import sun.security.x509.DistributionPointName;

@Controller
public class HelloController {

    @GetMapping("hello")//hello요청이 들어오면 return인 hello.html을 띄어준다
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";//model이란 것을 hello.html로 넘겨라라는 뜻
    }

    @GetMapping("hello-mvc")//getmapping은 새로운 페이지 만든다는것
    public String helloMvc(@RequestParam("name")String name, Model model){
        //이름을 손영진으로 해놓으면 String name 은 손영진으로 바뀜(밑에서 계속)
        model.addAttribute("name", name);
        //뒤에 있는 name도 손영진으로 바뀌게 된다. 그리고 model에 담긴다 (밑에서 계속)
        return "hello-template";
        //template으로 넘어가고 hello-template에 있는 name에도 손영진으로
        //template은 view가 있음

    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello " + name;
        //api는 view가 없고 문자그대로 출력해버림
    }
    @GetMapping("hello-api")
    @ResponseBody
    public  Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
