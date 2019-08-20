package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import com.example.demo.vo.ResourcesVo;
import com.example.demo.vo.RoleVo;
import com.example.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where user_name=#{name}")
    User findByName(String name);

    UserVo findUserByName(String name);

    List<RoleVo> findRoleByUserId(Integer userId);

    List<ResourcesVo> findResourceByRoleId(Integer RoleId);
}
