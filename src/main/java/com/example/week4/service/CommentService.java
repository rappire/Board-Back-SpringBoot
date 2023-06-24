package com.example.week4.service;

import com.example.week4.dao.CommentDAO;
import com.example.week4.dto.Comment;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * CommentService
 * Comment 에 관한 서비스를 실행하는 객체
 */
@Service
public class CommentService {
    private final CommentDAO commentDAO;


    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    /**
     * getCategory
     * 댓글 리스트를 받아오는 함수
     */
    public List<Comment> getComment(long id){
        return commentDAO.getComment(id);
    }
    /**
     * postComment
     * 댓글을 저장하는 함수
     */
    public void postComment(Comment comment){
        commentDAO.postComment(comment);
    }

}
