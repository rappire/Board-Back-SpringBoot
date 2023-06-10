package com.example.week4.dao;

import com.example.week4.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * ArticleDao
 * 글에 대해서 CRUD 를 실행하는 객체
 */
@Mapper
public interface ArticleDAO {
    /**
     * getArticleList
     * Article 객체 배열을 받아오는 함수
     */
    public List<Article> getArticleList();
    /**
     * getArticleList
     * Article 객체 한개를 id로 검색해서 가져오는 함수
     */
    public Article getArticle(long id);
    /**
     * postArticle
     * Article 객체 한개를 저장하는 함수
     */
    public void postArticle(Article article);
    /**
     * getPassword
     * Article 객체의 패스워드를 가져오는 함수
     */
    public String getPassword(long id);
    /**
     * putArticle
     * Article 객체 한개를 수정하는 함수
     */
    public void putArticle(Article article);
    /**
     * plusView
     * Article 객체의 조회수를 늘리는 함수 *
     */
    public void plusView(long id);
    /**
     * deleteArticle
     * Article 객체를 제거하는 함수
     */
    public void deleteArticle(long id);
}
