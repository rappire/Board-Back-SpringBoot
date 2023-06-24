package com.example.week4.service;

import com.example.week4.dao.CategoryDAO;
import com.example.week4.dto.Category;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * CommentService
 * Comment 에 관한 서비스를 실행하는 객체
 */
@Service
public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    /**
     * getCategory
     * 카테고리 리스트를 받아오는 함수
     */
    public List<Category> getCategory(){
        return categoryDAO.getCategory();
    };
}
