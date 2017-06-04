package com.example.demo.annotation;

/**
 * Created by tianxianglan on 2017/6/4.
 */
public enum PermissionEnum {
    ADMIN("ADMIN"),
    COMMON_USER("COMMON_USER");

    private String value;

    PermissionEnum(String value){
        value = this.value;
    }

    @Override
    public String toString() {
        return value;
    }
}
