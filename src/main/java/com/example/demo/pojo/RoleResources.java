package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class RoleResources implements Serializable{

    private Integer id;

    private Integer roleId;

    private Integer resourcesId;

}