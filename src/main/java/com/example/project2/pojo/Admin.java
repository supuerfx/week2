package com.example.project2.pojo;

import lombok.*;

/**
 * admin实体类
 * @author master
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
}
