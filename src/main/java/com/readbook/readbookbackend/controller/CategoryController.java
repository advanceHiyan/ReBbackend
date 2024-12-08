/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.CategoryService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/getAll")
    public Result getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/admin/newcate")
    public Result addNewCategory(String catename, BigInteger adminid) {
        return categoryService.addNewCategory(catename, adminid);
    }
}
