package com.example.demo.comment;

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

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return CommentService.createComment(comment);
    }

}
