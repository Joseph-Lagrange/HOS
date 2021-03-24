package com.hos.core.test;

import com.hos.core.auth.IAuthService;
import com.hos.core.auth.model.ServiceAuth;
import com.hos.core.auth.model.TokenInfo;
import com.hos.mybatis.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:53
 * Description: TODO
 */
public class AuthServiceTest extends BaseTest {

    @Autowired
    @Qualifier("authServiceImpl")
    IAuthService authService;

    @Test
    public void addToken() {
        TokenInfo tokenInfo = new TokenInfo("Mike");
        authService.addToken(tokenInfo);
    }

    @Test
    public void refreshToken() {
        List<TokenInfo> tokenInfos = authService.getTokenInfos("Mike");
        tokenInfos.forEach(tokenInfo -> {
            authService.refreshToken(tokenInfo.getToken());
        });
    }

    @Test
    public void deleteToken() {
        List<TokenInfo> tokenInfos = authService.getTokenInfos("Mike");
        if (tokenInfos.size() > 0) {
            authService.deleteToken(tokenInfos.get(0).getToken());
        }
    }

    @Test
    public void addAuth() {
        List<TokenInfo> tokenInfos = authService.getTokenInfos("Mike");
        if (tokenInfos.size() > 0) {
            ServiceAuth serviceAuth = new ServiceAuth();
            serviceAuth.setAuthTime(new Date());
            serviceAuth.setBucketName("testBucket");
            serviceAuth.setTargetToken(tokenInfos.get(0).getToken());
            authService.addAuth(serviceAuth);
        }
    }

    @Test
    public void deleteAuth() {
        List<TokenInfo> tokenInfos = authService.getTokenInfos("Mike");
        if (tokenInfos.size() > 0) {
            authService.deleteAuth("testBucket", tokenInfos.get(0).getToken());
        }
    }

}
