package com.example.week4.controller;

import com.example.week4.dao.CategoryDAO;
import com.example.week4.dto.Category;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final CategoryDAO newDAO;
    public CategoryController(CategoryDAO newDAO) {
        this.newDAO = newDAO;
    }

    @RequestMapping("/category")
    public Map<String, List<Category>> categories() throws Exception{
        Map< String, List<Category>> rtnObj = new HashMap<>();
        List<Category> categoryList = newDAO.getCategory();
        System.out.println("category->" + categoryList.toString());
        rtnObj.put("category", categoryList);
        return rtnObj;
    }
}
