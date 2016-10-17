package com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
public class RegionType {

    /**
     * code : 1
     * msg : success
     * obj : [{"cartype_id":"4","start_price":"78.00","start_distance":"5","carname":"小型厢货","overkilometersfee":"4.00","capaticy":"1.5","lwh":"2*1.6*1.5","carimg":"http://suyun.oss-cn-hangzhou.aliyuncs.com/suyun/user/images/smallloadtruck.png"},{"cartype_id":"10","start_price":"150.00","start_distance":"5","carname":"小型平板","overkilometersfee":"4.00","capaticy":"1.5","lwh":"2.0*1.6*1.5","carimg":"http://suyun.oss-cn-hangzhou.aliyuncs.com/suyun/user/images/smallflatcar.png"},{"cartype_id":"12","start_price":"180.00","start_distance":"5","carname":"大型平板","overkilometersfee":"5.00","capaticy":"1.8","lwh":"4.2*2.1*2.4","carimg":"http://suyun.oss-cn-hangzhou.aliyuncs.com/suyun/user/images/bigflatcar.png"}]
     */

    private int code;
    private String msg;
    /**
     * cartype_id : 4
     * start_price : 78.00
     * start_distance : 5
     * carname : 小型厢货
     * overkilometersfee : 4.00
     * capaticy : 1.5
     * lwh : 2*1.6*1.5
     * carimg : http://suyun.oss-cn-hangzhou.aliyuncs.com/suyun/user/images/smallloadtruck.png
     */

    private List<ObjBean> obj;

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

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        private String cartype_id;
        private String start_price;
        private String start_distance;
        private String carname;
        private String overkilometersfee;
        private String capaticy;
        private String lwh;
        private String carimg;

        public String getCartype_id() {
            return cartype_id;
        }

        public void setCartype_id(String cartype_id) {
            this.cartype_id = cartype_id;
        }

        public String getStart_price() {
            return start_price;
        }

        public void setStart_price(String start_price) {
            this.start_price = start_price;
        }

        public String getStart_distance() {
            return start_distance;
        }

        public void setStart_distance(String start_distance) {
            this.start_distance = start_distance;
        }

        public String getCarname() {
            return carname;
        }

        public void setCarname(String carname) {
            this.carname = carname;
        }

        public String getOverkilometersfee() {
            return overkilometersfee;
        }

        public void setOverkilometersfee(String overkilometersfee) {
            this.overkilometersfee = overkilometersfee;
        }

        public String getCapaticy() {
            return capaticy;
        }

        public void setCapaticy(String capaticy) {
            this.capaticy = capaticy;
        }

        public String getLwh() {
            return lwh;
        }

        public void setLwh(String lwh) {
            this.lwh = lwh;
        }

        public String getCarimg() {
            return carimg;
        }

        public void setCarimg(String carimg) {
            this.carimg = carimg;
        }
    }
}
