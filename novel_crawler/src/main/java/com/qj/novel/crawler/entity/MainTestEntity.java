package com.qj.novel.crawler.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MainTestEntity {
    private Integer id;
    private String name;
    private Integer age;
    private Integer typeCd;
    private LocalDateTime createDate;
}
