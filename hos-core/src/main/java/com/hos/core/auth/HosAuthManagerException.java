package com.hos.core.auth;

import com.hos.core.HosException;

/**
 * Author: DiBin
 * Date: Created in 2021/3/24 20:44
 * Description: TODO
 */
public class HosAuthManagerException extends HosException {

    private int code;

    private String message;

    public HosAuthManagerException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public HosAuthManagerException(int code, String message) {
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
