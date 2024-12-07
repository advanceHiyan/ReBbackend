/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.ArrayList;

@SpringBootTest
class ReadBookBackendApplicationTests {

    @Test
    void contextLoads() {
        BigInteger b = new BigInteger("1");
        BigInteger b2 = new BigInteger("1");
        System.out.println(b.equals(b2));
        System.out.println(b == b2);
        ArrayList<String> list = new ArrayList<>();
        list.add("原神");
        list.add("2");
        list.add("3");
        System.out.println(list);
    }



}
