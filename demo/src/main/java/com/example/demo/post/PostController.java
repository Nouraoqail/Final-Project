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
   private final UserRepository userRepository;
   private final TypeRepository typeRepository;
    @Autowired
    public PostController(PostService postService, UserRepository userRepository, TypeRepository typeRepository) {
        this.PostService = postService;
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
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
        Long u_id = post.getUser().getId();
        User u = userRepository.findById(u_id).orElse(null);
        post.setUser(u);
        Long t_id = post.getType().getId();
        Type t = typeRepository.findById(t_id).orElse(null);
        post.setType(t);
        return PostService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id){
        PostService.deletePost(id);
    }

}
