package com.example.week4.controller;

import com.example.week4.dto.Comment;
import com.example.week4.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CommentController
 * /comment 경로를 처리하는 controller
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * postComment
     * Comment 와 Article 의 id를 받아서 DB에 저장하는 함수
     */
    @PostMapping("/{id}")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) throws Exception{
        commentService.postComment(comment);
        System.out.println("comment->" + comment.toString());
        return ResponseEntity.ok(comment);
    }
}
