package com.hos.core.auth.model;

import java.util.Date;

/**
 * Author: DiBin
 * Date: Created in 2021/3/24 20:48
 * Description: TODO
 */
public class ServiceAuth {

    private String bucketName;

    private String targetToken;

    private Date authTime;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getTargetToken() {
        return targetToken;
    }

    public void setTargetToken(String targetToken) {
        this.targetToken = targetToken;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

}
