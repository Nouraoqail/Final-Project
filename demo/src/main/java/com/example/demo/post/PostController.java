package com.example.demo.post;

import com.example.demo.type.Type;
import com.example.demo.type.TypeRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
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
        this.PostService = postService;
    }

    @GetMapping
    public List<Post> getPost(){
        return PostService.getPost();
    }

    @GetMapping("/{id}")
    public Post getPosts(@PathVariable String id){
        return PostService.getPosts(id);
    }

    @GetMapping("getByType/{type}") //علشان يفرق بينها وبين الid
    public List<Post> getPostByType(@PathVariable String type){
        return PostService.getPostByType(type);
    }

    @PostMapping("/createPost")
    public Post createPost(@RequestBody Post post){
        return PostService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id){
        PostService.deletePost(id);
    }

}
