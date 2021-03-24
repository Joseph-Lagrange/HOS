package com.hos.core.user;

import com.hos.core.user.model.UserInfo;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:33
 * Description: TODO
 */
public interface IUserService {

    boolean addUser(UserInfo userInfo);

    boolean updateUserInfo(String userId, String password, String detail);

    boolean deleteUser(String userId);

    UserInfo getUserInfo(String userId);

    UserInfo checkPassword(String userName, String password);

    UserInfo getUserInfoByName(String userName);

}
