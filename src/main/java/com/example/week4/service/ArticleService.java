package com.example.week4.service;

import com.example.week4.dao.ArticleDAO;
import com.example.week4.dao.CommentDAO;
import com.example.week4.dto.Article;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ArticleService
 * Article 에 관한 서비스를 실행하는 객체
 */
@Service
public class ArticleService {
    private final ArticleDAO articleDAO;

    public ArticleService(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    /**
     * getArticleList
     * Article 객체 배열을 받아오는 함수
     */
    public List<Article> getArticleList(){
        return articleDAO.getArticleList();
    }
    /**
     * getArticleList
     * Article 객체 한개를 id로 검색해서
     * 조회수를 1 증가시키고, 가져오는 함수
     */
    public Article getArticle(long id){
        articleDAO.plusView(id);
        return articleDAO.getArticle(id);
    }
    /**
     * postArticle
     * Article 객체 한개를 저장하는 함수
     */
    public void postArticle(Article article){
        articleDAO.postArticle(article);
    }
    /**
     * putArticle
     * Article 객체 한개를 수정하는 함수
     */
    public void putArticle(Article article){
        articleDAO.putArticle(article);
    }
    /**
     * deleteArticle
     * Article 객체를 제거하는 함수
     */
    public void deleteArticle(long id){
        articleDAO.deleteArticle(id);
    }
    /**
     * getPassword
     * Article 객체의 패스워드를 가져오는 함수
     */
    public String getPassword(long id){
        return articleDAO.getPassword(id);
    }


}
