package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserVo implements Serializable {

    private  Integer id;

    private String username;

    private String password;

    private Set<RoleVo> roles;

}
