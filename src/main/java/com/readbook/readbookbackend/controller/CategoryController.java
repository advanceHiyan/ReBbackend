package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.CategoryService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/getAll")
    public Result getAllCategories() {
        return categoryService.getAllCategories();
    }
}
