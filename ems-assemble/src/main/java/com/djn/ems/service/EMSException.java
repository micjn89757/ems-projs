package com.djn.ems.service;

/**
 * 自定义异常
 * 1. 继承Exception
 * 2. 提供2个构造器
 */
public class EMSException extends Exception {
    public EMSException(String message) {
        super(message);
    }

    public EMSException(Throwable cause) {
        super(cause);
    }
}
