package com.example.demo.post;

import com.example.demo.type.Type;
import com.example.demo.type.TypeRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final PostRepository PostRepository;
    private final UserRepository userRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public PostService(com.example.demo.post.PostRepository postRepository, UserRepository userRepository, TypeRepository typeRepository) {
        PostRepository = postRepository;
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
    }

    public List<Post> getPost(){
        List <Post> listP = PostRepository.findAll();
        Collections.reverse(listP);
        return listP;
    }

    public Post getPosts(String id){
        Long post_id= Long.parseLong(id);
        return PostRepository.findById(post_id).orElse(null);
    }

    public Post createPost(Post post){

        Long u_id = post.getUser().getId();
        System.out.println(userRepository.findById(u_id).orElse(null));
        User u = userRepository.findById(u_id).orElse(null);
        post.setUser(u);
        String type = post.getType().getType();
        Type t = typeRepository.findByType(type);
        post.setType(t);
        return PostRepository.save(post);
    }

    public void deletePost(String id){
        Long post_id=Long.parseLong(id);
        PostRepository.deleteById(post_id);
    }

    public List<Post> getPostByType(String type) {
       return PostRepository.findByType_type(type);
    }
}
