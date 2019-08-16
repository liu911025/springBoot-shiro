package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Resources implements Serializable{

    private Integer id;

    /**
     * 资源名称
     */
    private String userName;

    /**
     * 资源url
     */
    private String resUrl;

    /**
     * 资源类型   1:菜单    2：按钮
     */
    private Integer userType;

    /**
     * 父资源
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer userSort;

}