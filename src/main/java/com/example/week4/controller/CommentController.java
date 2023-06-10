package com.example.week4.controller;

import com.example.week4.dao.ArticleDAO;
import com.example.week4.dao.CommentDAO;
import com.example.week4.dto.Article;
import com.example.week4.dto.Comment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentDAO commentDAO;
    public CommentController(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) throws Exception{
        commentDAO.postComment(comment);
        System.out.println("comment->" + comment.toString());
        return ResponseEntity.ok(comment);
    }
}
