package com.example.demo.post;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="posts")
@CrossOrigin("*")
public class PostController {

   private final PostService PostService;
    @Autowired
    public PostController(PostService postService) {
        PostService = postService;
    }

    @GetMapping
    public List<Post> getPost(){
        return PostService.getPost();
    }

    @GetMapping("/{id}")
    public Post getPosts(@PathVariable String id){
        return PostService.getPosts(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return PostService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id){
        PostService.deletePost(id);
    }

}
