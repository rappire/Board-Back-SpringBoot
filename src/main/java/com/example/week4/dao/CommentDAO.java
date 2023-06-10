package com.example.week4.dao;

import com.example.week4.dto.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * CommentDAO
 * 댓글에 대해서 READ, WRITE 를 실행하는 객체
 */
@Mapper
public interface CommentDAO {
    /**
     * getCategory
     * 댓글 리스트를 받아오는 함수
     */
    public List<Comment> getComment(long id);
    /**
     * postComment
     * 댓글을 저장하는 함수
     */
    public void postComment(Comment comment);
}
