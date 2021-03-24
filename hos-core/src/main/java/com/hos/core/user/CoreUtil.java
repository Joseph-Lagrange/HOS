package com.hos.core.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 21:00
 * Description: TODO
 */
public class CoreUtil {

    public final static String SYSTEM_USER = "SuperAdmin";

    public static String getMd5Password(String str) {
        String result = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    builder.append(0);
                }
                builder.append(Integer.toHexString(bt));
            }
            result = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
