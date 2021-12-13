package com.example.demo.comment;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository CommentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        CommentRepository = commentRepository;
    }

    public List<Comment> getComment(){
        return CommentRepository.findAll();
    }

    public Comment getComments(String id){
        Long comment_id= Long.parseLong(id);
        return CommentRepository.findById(comment_id).orElse(null);
    }

    public Comment createComment(Comment comment){
        return CommentRepository.save(comment);
    }

}
