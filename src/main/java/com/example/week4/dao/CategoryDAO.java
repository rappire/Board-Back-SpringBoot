package com.example.week4.dao;

import com.example.week4.dto.Category;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * CategoryDAO
 * 글에 대해서 READ 를 실행하는 객체
 */
@Mapper
public interface CategoryDAO {
    /**
     * getCategory
     * 카테고리 리스트를 받아오는 함수
     */
    public List<Category> getCategory();
}
