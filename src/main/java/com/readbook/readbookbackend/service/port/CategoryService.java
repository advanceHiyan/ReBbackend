/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    void addNewCategories(List<String> categories);


    Result addBookCategory(OneBook book, List<String> categories);

    Result getAllCategories();

    ArrayList<BigInteger> getCateIds(ArrayList<String> cates);

    ArrayList<BigInteger> getCateSelectBookIds(ArrayList<String> cates);

    Result addNewCategory(String catename, BigInteger adminid);
}
