package com.example.demo.common;

/**
 * Created by tianxianglan on 2017/6/17.
 */
public class Response {
    public short status;
    public String errmsg;
    public Object object;

    public Response() {
    }

    public Response(String errmsg) {
        this.errmsg = errmsg;
    }

    public Response(short status) {
        this.status = status;
    }

    public Response(short status, String errmsg, Object object) {
        this.status = status;
        this.errmsg = errmsg;
        this.object = object;
    }

    public Response(short status, String errmsg) {
        this.status = status;
        this.errmsg = errmsg;
    }
}
