package com.example.demo.post;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository PostRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        PostRepository = postRepository;
    }
    public List<Post> getPost(){
        return PostRepository.findAll();
    }

    public Post getPosts(String id){
        Long post_id= Long.parseLong(id);
        return PostRepository.findById(post_id).orElse(null);
    }

    public Post createPost(Post post){

        return PostRepository.save(post);
    }

    public void deletePost(String id){
        Long post_id=Long.parseLong(id);
        PostRepository.deleteById(post_id);
    }
}
