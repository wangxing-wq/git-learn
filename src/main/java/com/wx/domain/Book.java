package com.wx.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class Book {

    private Long id;

    @NotBlank(message = "书籍标题不能为空")
    private String title;

    @NotBlank(message = "作者不能为空")
    private String author;

    @Positive(message = "页数必须是正整数")
    private int pageCount;
    
}
