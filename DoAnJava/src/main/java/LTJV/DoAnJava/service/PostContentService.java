package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.PostContent;
import LTJV.DoAnJava.repository.IPostContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostContentService {
    @Autowired
    private IPostContentRepository postContentRepository;
    public List<PostContent> getAllPostContents(){return postContentRepository.findAll();}

    public PostContent getPostContentById(Long id){
        Optional<PostContent> optional = postContentRepository.findById(id);
        return optional.orElse(null);
    }

    public void addPostContent(PostContent PostContent){postContentRepository.save(PostContent);}
    public void updatePostContent(PostContent PostContent){postContentRepository.save(PostContent);}
    public void deletePostContent(Long id){postContentRepository.deleteById(id);}
}
