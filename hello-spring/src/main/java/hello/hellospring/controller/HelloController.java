package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; //hello.html을 찾아서 가라는 뜻
    }
}
