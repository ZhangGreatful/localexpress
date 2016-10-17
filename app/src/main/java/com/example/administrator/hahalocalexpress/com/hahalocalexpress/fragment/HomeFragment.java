package com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.Web.WebInterface;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity.SelectCityActivity;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.CarInfoAdapter;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.City;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.RegionType;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/9/29.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private View homeLayout;
    private Context mContext;
    private ListView mListView;
    private TextView cityName;
    private CarInfoAdapter carInfoAdapter;
    private LinearLayout selectCity;
    private OkHttpClient client;
    private WebInterface webInterface;
    //    日志拦截器
    private HttpLoggingInterceptor loggingInterceptor;

    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (homeLayout == null) {
            homeLayout = inflater.inflate(R.layout.home_fragment, null);
        }
        return homeLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mContext = getActivity();
        webInterface = new WebInterface();
        loggingInterceptor = new HttpLoggingInterceptor();
        cityName = (TextView) this.getActivity().findViewById(R.id.text);
        selectCity = (LinearLayout) this.getActivity().findViewById(R.id.city);
        mListView = (ListView) this.getActivity().findViewById(R.id.lv_car);
        mListView.setDivider(null);
        selectCity.setOnClickListener(this);
        initData();
        location();
    }

    //获取当前的定位城市
    private void location() {
        mLocationClient = new AMapLocationClient(mContext);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
//该方法默认为false。
        mLocationOption.setOnceLocation(true);
        //设置是否强制刷新WIFI，默认为true，强制刷新。
        mLocationOption.setWifiActiveScan(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);

        mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //  可在其中解析amapLocation获取相应内容。
                        String city = aMapLocation.getCity();
                        System.out.println("city===========" + city);
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        };
//启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void onPause() {
        super.onPause();
        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
        mLocationClient.onDestroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。

    }


    private void initData() {
        client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        String cityid = "120100000000";
        cityName.setText("天津");
        Request request = new Request.Builder()
                .url(webInterface.get_region_type + cityid)
                .build();
        client.newCall(request).enqueue(getRegionTypeCallback);

    }

    Callback getRegionTypeCallback = new Callback() {
        @Override
        public void onFailure(Call call, final IOException e) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, "数据请求失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Gson gson = new Gson();
            final RegionType regionType = gson.fromJson(response.body().charStream(), RegionType.class);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    carInfoAdapter = new CarInfoAdapter(mContext, regionType);
                    mListView.setAdapter(carInfoAdapter);
                }
            });

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.city:
                Intent intent = new Intent(mContext, SelectCityActivity.class);
                startActivity(intent);
                break;
        }
    }

}
