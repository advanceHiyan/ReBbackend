/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private BigInteger id;
    private String userName;
    private String email;
    private String password;
    private Integer failuresOnLogin;
    private LocalDateTime lastFailureOnLogin;
    private Integer uploaded;
    private Integer userRole;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
