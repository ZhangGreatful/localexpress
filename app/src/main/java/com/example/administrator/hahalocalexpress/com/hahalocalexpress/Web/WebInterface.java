package com.example.administrator.hahalocalexpress.com.hahalocalexpress.Web;

/**
 * Created by Administrator on 2016/10/14.
 */
public class WebInterface {

    public static String get_region_type = "http://suyun.1xueche.cn/index.php/Api/Placeorder/getRegionCartype/cityid/";//获取地区车型
    public static String get_open_city = "http://suyun.1xueche.cn/index.php/Api/Placeorder/getOpencity";//开通服务城市
    public static String extra_service = "http://suyun.1xueche.cn/index.php/Api/Placeorder/extraService";//获取额外服务
    public static String place_order = "http://suyun.1xueche.cn/index.php/Api/Placeorder/placeOrder";//订单提交
    public static String check_transaction = "http://suyun.1xueche.cn/index.php/Api/Placeorder/checkTransaction";//验证订单有效性
    public static String pushed_driver = "http://suyun.1xueche.cn/index.php/Api/Placeorder/pushedDriver";//已推送司机后台记录接口
    public static String get_pushing_order = "http://suyun.1xueche.cn/index.php/Api/Placeorder/getPushingorder";//获取当前可推送得订单
    public static String change_order_status = "http://suyun.1xueche.cn/index.php/Api/Placeorder/changeOrderstatus";//更改订单状态
    public static String recommend_driver = "http://suyun.1xueche.cn/index.php/Api/Placeorder/recommendDriver";//已抢单司机后台记录
    public static String get_driver_info = "http://suyun.1xueche.cn/index.php/Api/Placeorder/getDriverinfo";//客户端展示司机信息
    public static String get_drivereval = "http://suyun.1xueche.cn/index.php/Api/Placeorder/getDrivereval";//展示司机的评论信息
    public static String replace_order = "http://suyun.1xueche.cn/index.php/Api/Placeorder/rePlaceOrder";//重新下单
    public static String choose_driver = "http://suyun.1xueche.cn/index.php/Api/Placeorder/chooseDriver";//选司机


}
