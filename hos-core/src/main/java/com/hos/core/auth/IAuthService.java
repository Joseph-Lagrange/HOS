package com.hos.core.auth;

import com.hos.core.auth.model.ServiceAuth;
import com.hos.core.auth.model.TokenInfo;

import java.util.List;

/**
 * Author: DiBin
 * Date: Created in 2021/3/24 20:57
 * Description: TODO
 */
public interface IAuthService {

    boolean addAuth(ServiceAuth auth);

    boolean deleteAuth(String bucketName, String token);

    boolean deleteAuthByBucket(String bucketName);

    boolean deleteAuthByToken(String token);

    ServiceAuth getServiceAuth(String bucketName, String token);

    boolean addToken(TokenInfo tokenInfo);

    boolean updateToken(String token, int expireTime, boolean isActive);

    boolean refreshToken(String token);

    boolean deleteToken(String token);

    boolean checkToken(String token);

    TokenInfo getTokenInfo(String token);

    List<TokenInfo> getTokenInfos(String creator);

}
