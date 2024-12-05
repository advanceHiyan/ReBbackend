package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.math.BigInteger;
import java.sql.Clob;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private BigInteger id;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger userId;
    private String username;
    private BigInteger bookId;
}
