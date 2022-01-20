package com.example.demo.comment;

import com.example.demo.post.Post;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService CommentService;
    @Autowired
    public CommentController(CommentService commentService) {
        CommentService = commentService;
    }

    @GetMapping
    public List<Comment> getComment(){
        return CommentService.getComment();
    }

    @GetMapping("/{id}")
    public Comment getComments(@PathVariable String id){
        return CommentService.getComments(id);
    }

//    @GetMapping("getByPostId/{post_id}")
//    public List<Comment> getCommentsByPostId(@PathVariable String post_id){
//        return CommentService.getCommentsByPostId(post_id);
//    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return CommentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable String id, @RequestBody Comment data) {

        return CommentService.updateComment(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id){
        CommentService.deleteComment(id);
    }
}
