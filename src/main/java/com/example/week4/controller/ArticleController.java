package com.example.week4.controller;



import com.example.week4.dao.ArticleDAO;
import com.example.week4.dao.CommentDAO;
import com.example.week4.dto.Article;
import com.example.week4.dto.Comment;
import com.example.week4.service.ArticleService;
import com.example.week4.service.CommentService;
import com.example.week4.util.CheckInput;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ArticleController
 * /article 경로를 처리하는 controller
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;
    public ArticleController(ArticleDAO articleDAO, CommentDAO commentDAO,
        ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    /**
     * getArticleList
     * Article 객체 배열을 리턴하는 함수
     * @return List<Article>
     */
    @GetMapping ("/list")
    public Map<String, Object> getArticleList() throws Exception{
        Map< String, Object> rtnObj = new HashMap<>();
        List<Article> articleList = articleService.getArticleList();
        System.out.println("Article->" + articleList.toString());
        rtnObj.put("articleList", articleList);
        return rtnObj;
    }

    /**
     * getArticle
     * id에 해당하는 Article 객체 하나와
     * Article 에 있는 Comment 배열을 리턴하는 함수
     * @return article, List<Comment>
     */
    @GetMapping("/{id}")
    public Map<String, Object> getArticle(@PathVariable("id") long id) throws Exception {
        Map<String, Object> rtnObj = new HashMap<>();
        Article article = articleService.getArticle(id);
        List<Comment> comment = commentService.getComment(id);
        System.out.println("Article->" + article.toString());
        rtnObj.put("article", article);
        rtnObj.put("comment", comment);
        return rtnObj;
    }


    /**
     * postArticle
     * Article 객체와 파일들을 받아서 DB에 저장하는 함수
    */
    @PostMapping("")
    public ResponseEntity<String> postArticle(@RequestPart("files") List<MultipartFile> files, @RequestPart("article") Article article) throws Exception {
        if (!CheckInput.checkWriteArticle(article)){
            return ResponseEntity.badRequest().body("error");
        }

        /**
         * TODO : 파일 이름 변경 및 파일 DB 저장
         */
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // 파일 저장 경로 설정
                String filePath = "C:/test/" + file.getOriginalFilename();

                try {
                    // 파일 저장
                    file.transferTo(new File(filePath));
                    System.out.println("File saved: " + file.getOriginalFilename());
                } catch (IOException e) {
                    System.out.println("Failed to save file: " + file.getOriginalFilename());
                    e.printStackTrace();
                    // 실패 시 적절한 예외 처리를 수행
                }
            }
        }
        System.out.println("Article->");

        return ResponseEntity.ok("success");
    }

    /**
     * putArticle
     * Article 객체와 파일들을 받아서 수정하는 함수
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> putArticle(@PathVariable("id") long id, @RequestBody Article article) throws Exception {
        String password = articleService.getPassword(id);
        if (!CheckInput.checkModifyArticle(article ,password)){
            return ResponseEntity.badRequest().body("error");
        }
        System.out.println("Article->");
        articleService.putArticle(article);
        return ResponseEntity.ok("success");
    }

    /**
     * deleteArticle
     * id를 받아서 해당하는 Article 과 Comment 를 삭제하는 함수
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") long id, @RequestParam("password") String password)throws Exception {
        String checkPassword = articleService.getPassword(id);
        if (!checkPassword.equals(password)){
            return ResponseEntity.badRequest().body(password);
        }
        System.out.println("Delete->" + id);
        articleService.deleteArticle(id);
        return ResponseEntity.ok("success");
    }
}
