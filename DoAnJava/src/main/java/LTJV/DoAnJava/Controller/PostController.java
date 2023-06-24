package LTJV.DoAnJava.Controller;

import LTJV.DoAnJava.Entity.Post;
import LTJV.DoAnJava.Entity.PostContent;
import LTJV.DoAnJava.service.PostContentService;
import LTJV.DoAnJava.service.PostService;
import LTJV.DoAnJava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PostContentService postContentService;
    @Autowired
    ProductService productService;

    @GetMapping("/add")
    public String addPostForm(Model model) {
        Post post = new Post();
        List<PostContent> postContents=new ArrayList<>();
        model.addAttribute("post", post);
        model.addAttribute("postContents",postContents);
        return "post/add";
    }
    @PostMapping("/add")
    public String addPost(@ModelAttribute("post") Post post,
                          @ModelAttribute("postContents") String postContents
                         ,@RequestParam("file") MultipartFile file
                         ,BindingResult bindingResult, Model model) {

        try{
            List<PostContent> contentList=PostContent.fromJsonList(postContents);
            for (PostContent i: contentList) {
                i.setPost(post);
            }
            post.setContents(contentList);
            post.setDate(Date.valueOf(LocalDate.now()));
            postService.addPost(file, post);
            return "redirect:/";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "error/404";
        }
    }
}
