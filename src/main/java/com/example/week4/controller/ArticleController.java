package com.example.week4.controller;



import static com.example.week4.util.CheckInput.checkWriteArticle;

import com.example.week4.dao.ArticleDAO;
import com.example.week4.dao.CommentDAO;
import com.example.week4.dto.Article;
import com.example.week4.dto.Comment;
import com.example.week4.util.CheckInput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleDAO articleDAO;
    private final CommentDAO commentDAO;
    public ArticleController(ArticleDAO articleDAO, CommentDAO commentDAO) {
        this.articleDAO = articleDAO;
        this.commentDAO = commentDAO;
    }

    @GetMapping ("/list")
    public Map<String, Object> articleList() throws Exception{
        Map< String, Object> rtnObj = new HashMap<>();
        List<Article> articleList = articleDAO.getArticleList();
        System.out.println("Article->" + articleList.toString());
        rtnObj.put("articleList", articleList);
        return rtnObj;
    }
    @GetMapping("/{id}")
    public Map<String, Object> getArticle(@PathVariable("id") long id) throws Exception {
        Map<String, Object> rtnObj = new HashMap<>();
        Article article = articleDAO.getArticle(id);
        articleDAO.plusView(id);
        List<Comment> comment = commentDAO.getComment(id);
        System.out.println("Article->" + article.toString());
        rtnObj.put("article", article);
        rtnObj.put("comment", comment);
        return rtnObj;
    }
    @PostMapping("")
    public ResponseEntity<String> postArticle(@RequestBody Article article) throws Exception {
        if (!CheckInput.checkWriteArticle(article)){
            return ResponseEntity.badRequest().body("error");
        }
        System.out.println("Article->");
        articleDAO.postArticle(article);
        return ResponseEntity.ok("success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putArticle(@PathVariable("id") long id, @RequestBody Article article) throws Exception {
        String password = articleDAO.getPassword(id);
        if (!CheckInput.checkModifyArticle(article ,password)){
            return ResponseEntity.badRequest().body("error");
        }
        System.out.println("Article->");
        articleDAO.putArticle(article);
        return ResponseEntity.ok("success");
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") long id, @RequestBody Article article)throws Exception {
        String checkPassword = articleDAO.getPassword(id);
        String password = article.getPassword();
        if (!checkPassword.equals(password)){
            return ResponseEntity.badRequest().body(password);
        }
        System.out.println("Delete->" + id);
        articleDAO.deleteArticle(id);
        return ResponseEntity.ok("success");
    }
}
