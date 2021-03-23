package com.hos.core;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 20:37
 * Description: Base Exception
 */
public abstract class HosException extends RuntimeException {

    protected String errorMessage;

    public HosException(String message, Throwable cause) {
        super(cause);
        this.errorMessage = message;
    }

    public abstract int errorCode();

    public String errorMessage() {
        return this.errorMessage;
    }

}
