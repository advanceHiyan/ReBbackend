/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.BookCategoryRela;
import com.readbook.readbookbackend.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Mapper
public interface CategoryMapper {

    int insertNewCategory(String cateName);

    int checkCategoryExists(String cateName);

    void addNewCategories(List<String> categories);

    BigInteger getIdByName(String cateName);

    void insertBookCategoryRela(BookCategoryRela bookCategoryRela);

    Category getCategoryByName(String cateName); //必须设置类id和数据库主键映射

    List<Category> getAllCategories();//必须设置类id和数据库主键映射

    BigInteger getCategoryIdByName(String cateName);

    void addCountByName(String cateName);

    ArrayList<BigInteger> getCateSelectBookIds(ArrayList<String> cateNames);

    void insertCategory(Category category);
}
