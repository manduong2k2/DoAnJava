package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Post;
import LTJV.DoAnJava.repository.IPostRepository;
import LTJV.DoAnJava.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private IPostRepository postRepository;
    public List<Post> getAllPosts(){return postRepository.findAll();}

    public Post getPostById(Long id){
        Optional<Post> optional = postRepository.findById(id);
        return optional.orElse(null);
    }

    public void addPost(MultipartFile file, Post post){
        postRepository.save(post);
        if(!file.isEmpty()){
            try{
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String uploadDir = "DoAnJava/src/main/resources/static/img/post-photos/" + post.getId();
                FileUploadUtil.saveFile(uploadDir,fileName,file);
                post.setCoverImage("img/post-photos/"+post.getId()+"/"+fileName);
                postRepository.save(post);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void updatePost(Post Post){postRepository.save(Post);}
    public void deletePost(Long id){postRepository.deleteById(id);}
}
