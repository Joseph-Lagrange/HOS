package com.hos.core.test;

import com.hos.core.user.IUserService;
import com.hos.core.user.model.SystemRole;
import com.hos.core.user.model.UserInfo;
import com.hos.mybatis.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:53
 * Description: TODO
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    @Qualifier("userServiceImpl")
    IUserService userService;

    @Test
    public void addUser() {
        UserInfo userInfo = new UserInfo("Mike", "123456", SystemRole.ADMIN, "no desc");
        userService.addUser(userInfo);
    }

    @Test
    public void getUser() {
        UserInfo userInfo = userService.getUserInfoByName("Mike");
        System.out.println(userInfo.getUserId() + "|" + userInfo.getUserName() + "|" + userInfo.getPassword());
    }

    @Test
    public void deleteUser() {
        UserInfo userInfo = userService.getUserInfoByName("Mike");
        userService.deleteUser(userInfo.getUserId());
    }

}
