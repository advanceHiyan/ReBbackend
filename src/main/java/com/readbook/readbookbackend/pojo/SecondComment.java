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
public class SecondComment {
    private BigInteger id;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private BigInteger userId;
    private String username;
    private BigInteger commentId;
    private BigInteger respondeeId;
}
