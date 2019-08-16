package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;

    private String userName;

    private String passWord;

    /**
     * 是否启用
     */
    private Integer lock;


}