package com.djn.ems.service;

import java.util.Objects;

public enum Status {
    FREE(0), USED(1), SCRAP(2);

    private final int statusCode;
    private Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        if (Objects.equals(super.name(), "FREE")) {
            return "空闲";
        }else if (Objects.equals(super.name(), "USED")) {
            return "使用";
        }else {
            return "损坏";
        }
    }
}
