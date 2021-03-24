package com.hos.core.user;

import com.hos.core.HosException;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 20:53
 * Description: User Manager Module Exception
 */
public class HosUserManagerException extends HosException {

    private int code;

    private String message;

    public HosUserManagerException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public HosUserManagerException(int code, String message) {
        super(message, null);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int errorCode() {
        return this.code;
    }

}
