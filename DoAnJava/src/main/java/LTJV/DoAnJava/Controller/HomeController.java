package LTJV.DoAnJava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(){
        return "home/index";
    }
    @GetMapping("/about")
    public String about(){
        return "home/about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }
    @GetMapping("/post")
    public String post(){
        return "home/post";
    }
}
