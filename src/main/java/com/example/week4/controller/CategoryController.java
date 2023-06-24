package com.example.week4.controller;

import com.example.week4.dto.Category;
import com.example.week4.service.CategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryController
 * /category 경로를 처리하는 controller
 */
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * categories
     * 카테고리 종류를 리턴하는 함수
     * @return List<Category>
     */
    @RequestMapping("/category")
    public Map<String, List<Category>> categories() throws Exception{
        Map< String, List<Category>> rtnObj = new HashMap<>();
        List<Category> categoryList = categoryService.getCategory();
        System.out.println("category->" + categoryList.toString());
        rtnObj.put("category", categoryList);
        return rtnObj;
    }
}
