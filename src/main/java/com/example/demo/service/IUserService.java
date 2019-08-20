package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;

public interface IUserService {

    User findByName(String name);

    UserVo findUserByName(String name);
}
