package com.example.demo.comment;

import com.example.demo.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
//    List<Comment> findByPost_Id(String id);
}
