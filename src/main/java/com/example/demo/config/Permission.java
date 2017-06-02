package com.example.demo.config;

/**
 * Created by cvter on 2017/6/2.
 */
public enum Permission {
    SYSTEM("SYSTEM"),                       //系统
    SYSTEM_VIEW("SYSTEM:VIEW"),             //系统查看
    DATA("DATA"),                           //数据简报
    DATA_VIEW("DATA:VIEW"),                 //数据简报查看
    RESOURCE("RESOURCE"),                   //资源
    RESOURCE_VIEW("RESOURCE:VIEW"),         //资源查看
    CLASS("CLASS"),                         //班级氛围
    CLASS_VIEW("CLASS:VIEW"),               //班级氛围查看
    CLASS_EDIT("CLASS:EDIT"),               //班级氛围编辑
    TEACHER("PERMISSION"),                  //教师管理
    TEACHER_VIEW("PERMISSION:VIEW"),        //教师管理查看
    TEACHER_EDIT("PERMISSION:EDIT");        //教师管理编辑

    private String value;

    Permission(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(DATA);
    }
}
