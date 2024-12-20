/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.BookMapper;
import com.readbook.readbookbackend.mapper.CategoryMapper;
import com.readbook.readbookbackend.pojo.BookCategoryRela;
import com.readbook.readbookbackend.pojo.Category;
import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.service.port.CategoryService;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.BookWithCate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void addNewCategories(List<String> categories) {
        List<String> categoryList = new ArrayList<>();
        for (String category : categories) {
            if (categoryMapper.getCategoryByName(category) == null) {
                categoryList.add(category);
            }
        }
        if (!categoryList.isEmpty()) {
            categoryMapper.addNewCategories(categoryList);
        }
    }

    @Override
    public Result addBookCategory(OneBook book, List<String> categories) {
        BigInteger bookId = book.getId();
        List<Category> categoryList = new ArrayList<>();
        for (String cate_name : categories) {
            categoryMapper.addCountByName(cate_name);
            Category category = categoryMapper.getCategoryByName(cate_name);
            categoryList.add(category);
            BigInteger categoryid = categoryMapper.getCategoryIdByName(cate_name);
            BookCategoryRela bookCategoryRela = new BookCategoryRela();
            bookCategoryRela.setBookId(new BigInteger("11")); //
            bookCategoryRela.setBookId(bookId);
            bookCategoryRela.setCateId(categoryid);
            categoryMapper.insertBookCategoryRela(bookCategoryRela);
        }
        BookWithCate bookWithCate = new BookWithCate(book, categoryList,0);
        return Result.success("Add book success And add book-category success", bookWithCate);
    }

    @Override
    public Result getAllCategories() {
        List<Category> categories = categoryMapper.getAllCategories();
        if (categories.isEmpty()) {
            return Result.error("No categories found","556");
        }
        return Result.success("Get all categories success", categories);
    }

    @Override
    public ArrayList<BigInteger> getCateIds(ArrayList<String> cates) {
        ArrayList<BigInteger> cateIds = new ArrayList<>();
        for (String cate : cates) {
            cateIds.add(categoryMapper.getCategoryIdByName(cate));
        }
        return cateIds;
    }

    @Override
    public ArrayList<BigInteger> getCateSelectBookIds(ArrayList<String> cates) {
        return categoryMapper.getCateSelectBookIds(cates);
    }

    @Override
    public Result addNewCategory(String catename, BigInteger adminid) {
        if(categoryMapper.getCategoryByName(catename)!= null) {
            return Result.error("Category already exist","566");
        }
        Category category = new Category();
        category.setCateName(catename);
        category.setReferenceNumber(0);
        categoryMapper.insertCategory(category);
        return Result.success("Add category success And add category success", category);
    }
}
