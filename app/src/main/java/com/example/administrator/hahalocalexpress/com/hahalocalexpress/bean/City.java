package com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
public class City {
    /**
     * code : 1
     * msg : success
     * obj : [{"city_id":"120100000000","city_name":"天津市"},{"city_id":"371400000000","city_name":"德州市"}]
     */

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getObj() {
        return obj;
    }

    public void setObj(List<Object> obj) {
        this.obj = obj;
    }

    private List<Object> obj;

}
