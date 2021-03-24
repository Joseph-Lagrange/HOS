package com.hos.core.auth.dao;

import com.hos.core.auth.model.ServiceAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

/**
 * Author: DiBin
 * Date: Created in 2021/3/24 20:49
 * Description: TODO
 */
@Mapper
public interface ServiceAuthMapper {

    void addAuth(@Param("auth") ServiceAuth auth);

    void deleteAuth(@Param("bucket") String bucketName, @Param("token") String token);

    void deleteAuthByToken(@Param("token") String token);

    void deleteAuthByBucket(@Param("bucket") String bucketName);

    @ResultMap("ServiceAuthResultMap")
    ServiceAuth getAuth(@Param("bucket") String bucketName, @Param("token") String token);

}
