package com.example.week4.util;

import com.example.week4.dto.Article;
import java.util.regex.Pattern;

public class CheckInput {
    /**
     * checkPassword
     *
     * @param password 확인할 패스워드
     * @return 패스워드가 조건에 맞는지 판별한 결과
     * 패스워드가 조건을 만족하는지 판별하는 함수
     */
    public static boolean checkPassword(String password) {
        String pattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{4,15}$";
        return Pattern.matches(pattern, password);
    }

    /**
     * checkRequest
     * @param article 글 수정이 맞게 되는지 확인할 article
     * @param confirmPassword 패스워드가 맞는지 확인할 confirmPassword
     * @return 글이 양식에 맞는지 판별한 결과
     * 글이 양식에 맞는지 판별하는 함수
     */
    public static boolean checkModifyArticle(Article article, String confirmPassword) {
        String writer = article.getWriter();
        String password = article.getPassword();
        String title = article.getTitle();
        String contents = article.getContents();
        if (writer == null) {
            return false;
        } else if (writer.length() < 3 || writer.length() >= 5) {
            return false;
        }
        if (password == null || password.compareTo(confirmPassword) != 0) {
            return false;
        }
        if (title == null) {
            return false;
        } else if (title.length() < 4 || title.length() >= 100) {
            return false;
        }
        if (contents == null) {
            return false;
        } else if (contents.length() < 4 || contents.length() >= 2000) {
            return false;
        }
        return true;
    }

    /**
     * checkRequest
     * @param article 글 생성이 맞게 되는지 확인할 article
     * @return 글이 양식에 맞는지 판별한 결과
     * 글이 양식에 맞는지 판별하는 함수
     */
    public static boolean checkWriteArticle(Article article) {
        Long category = article.getCategoryId();
        String writer = article.getWriter();
        String password = article.getPassword();
        String title = article.getTitle();
        String contents = article.getContents();
        if (category == null) {
            return false;
        }
        if (writer == null) {
            return false;
        } else if (writer.length() < 3 || writer.length() >= 5) {
            return false;
        }
        if (password == null) {
            return false;
        } else if (!checkPassword(password)) {
            return false;
        }
        if (title == null) {
            return false;
        } else if (title.length() < 4 || title.length() >= 100) {
            return false;
        }
        if (contents == null) {
            return false;
        } else if (contents.length() < 4 || contents.length() >= 2000) {
            return false;
        }
        return true;
    }
}
