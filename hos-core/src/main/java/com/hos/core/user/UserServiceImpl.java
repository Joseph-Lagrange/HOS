package com.hos.core.user;

import java.util.Date;

import com.hos.core.auth.dao.TokenInfoMapper;
import com.hos.core.auth.model.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.hos.core.user.dao.UserInfoMapper;
import com.hos.core.user.model.UserInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:36
 * Description: TODO
 */
@Transactional
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    private long LONG_REFRESH_TIME = 4670409600000L;

    private int LONG_EXPIRE_TIME = 36500;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    TokenInfoMapper tokenInfoMapper;

    @Override
    public boolean addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
        Date date = new Date();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setToken(userInfo.getUserId());
        tokenInfo.setActive(true);
        tokenInfo.setCreateTime(date);
        tokenInfo.setCreator(CoreUtil.SYSTEM_USER);
        tokenInfo.setExpireTime(LONG_EXPIRE_TIME);
        tokenInfo.setRefreshTime(date);
        tokenInfoMapper.addToken(tokenInfo);
        return true;
    }

    @Override
    public boolean updateUserInfo(String userId, String password, String detail) {
        userInfoMapper
                .updateUserInfo(userId,
                        Strings.isNullOrEmpty(password) ? null : CoreUtil.getMd5Password(password),
                        Strings.emptyToNull(detail));
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
        userInfoMapper.deleteUser(userId);
        tokenInfoMapper.deleteToken(userId);
        return true;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.getUserInfo(userId);
    }

    @Override
    public UserInfo checkPassword(String userName, String password) {
        return userInfoMapper.checkPassword(userName, password);
    }

    @Override
    public UserInfo getUserInfoByName(String userName) {
        return userInfoMapper.getUserInfoByName(userName);
    }

}
