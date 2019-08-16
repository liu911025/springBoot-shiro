package com.example.demo.service;

import com.example.demo.pojo.User;

public interface IUserService {

    User findByName(String name);
}
