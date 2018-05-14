package com.boke.dao;

import com.boke.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByAccount(String account);

    User selectUserByAccountAndPasswd(@Param("account") String account, @Param("password") String password);


}