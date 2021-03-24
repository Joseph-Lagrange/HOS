package com.hos.core.user.dao;

import com.hos.core.user.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:06
 * Description: TODO
 */
@Mapper
public interface UserInfoMapper {

    void addUser(@Param("userInfo") UserInfo userInfo);

    int updateUserInfo(@Param("userId") String userId, @Param("password") String password,
                       @Param("detail") String detail);

    int deleteUser(@Param("userId") String userId);

    @ResultMap("UserInfoResultMap")
    UserInfo getUserInfo(@Param("userId") String userId);

    UserInfo checkPassword(@Param("userName") String userName,
                           @Param("password") String password);

    @ResultMap("UserInfoResultMap")
    UserInfo getUserInfoByName(@Param("userName") String userName);

}
