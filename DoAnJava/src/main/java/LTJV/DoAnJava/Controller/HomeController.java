package LTJV.DoAnJava.Controller;

import LTJV.DoAnJava.Entity.Post;
import LTJV.DoAnJava.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private PostService postService;
    @GetMapping
    public String index(Model model){
        model.addAttribute("posts",postService.getAllPosts());
        return "home/index";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model){
        Post post=postService.getPostById(id);
        if(post==null) return "error/404";
        model.addAttribute("post",post);
        model.addAttribute("image",post.getCoverImage());
        return "post/details";
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
