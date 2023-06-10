package com.example.week4.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    /**
     * id           : 댓글 ID
     */
    private Long id;
    /**
     * article_id   : 댓글이 어떤 글에 쓰여졌는지 알기 위한 글 ID
     */
    private Long articleId;
    /**
     * writer       : 댓글 작성자
     */

    private String writer;
    /**
     * contents     : 댓글 내용
     */
    private String contents;
}
