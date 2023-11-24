package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; //hello.html을 찾아서 가라는 뜻
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, Model model) {
        Hello hello = new Hello();
        hello.setHello(name);

        return hello; //객체를 반환하고 @ResponseBody를 하면 JSON으로 RETURN된다.
    }

    static class Hello { //static을 쓰면 class안에 class를 만들 수 있다.
        private String hello;

        public String getHello() {
            return hello;
        }

        public void setHello(String hello) {
            this.hello = hello;
        }
    }

}
