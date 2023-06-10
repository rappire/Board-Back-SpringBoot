package com.example.week4.dto;

import java.util.Date;
import javax.persistence.Column;
import lombok.Data;

@Data
public class Article {
    /**
     * id           : 글 ID
     */
    private Long id;
    /**
     * category     : 카테고리
     */
    private String category;
    /**
     * category_id  : 카테고리 테이블에서 카테고리를 불러오기 위한 ID
     */
    private Long categoryId;
    /**
     * title        : 글 제목
     */
    private String title;
    /**
     * writer       : 글 작성자
     */
    private String writer;
    /**
     * views        : 조회수
     */
    private int views;
    /**
     * reg_date     : 글 등록날짜
     */
    private Date regDate;
    /**
     * edit_date    : 글 수정날짜
     */
    private Date editDate;
    /**
     * password     : 비밀번호
     */
    private String password;
    /**
     * contents     : 글 내용
     */
    private String contents;
}
