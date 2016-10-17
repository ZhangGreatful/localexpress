package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.Web.WebInterface;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.CityAdapter;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.City;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.Object;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/10/9.
 */
public class SelectCityActivity extends Activity implements View.OnClickListener {

    private Context mContext;
    private WebInterface webInterface;
    private OkHttpClient client = null;
    private ListView listView;
    private ImageView mBack;
    private CityAdapter adapter;
    private TextView locationCity;
    private List<Object> list = new ArrayList<>();
    //    日志拦截器
    private HttpLoggingInterceptor loggingInterceptor;

    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.select_city);
        mContext = this;
        initView();
        initData();
        location();

    }
    //获取当前的定位城市
    private void location() {
        mLocationClient = new AMapLocationClient(getApplicationContext());
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
        Request request = new Request.Builder()
                .url(webInterface.get_open_city)
                .build();
        client.newCall(request).enqueue(getCityListCallback);

    }

    private void initView() {
        webInterface = new WebInterface();
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//设置等级
        mBack = (ImageView) findViewById(R.id.close);
        locationCity= (TextView) findViewById(R.id.location_city);
        listView = (ListView) findViewById(R.id.city_list);
        setListViewHeightBasedOnChildren(listView);
        mBack.setOnClickListener(this);
        locationCity.setOnClickListener(this);
    }

    //      异步请求callback
    Callback getCityListCallback = new Callback() {
        @Override
        public void onFailure(Call call, final IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(SelectCityActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
//            String body = response.body().toString();
            Gson gson = new Gson();

            City city = gson.fromJson(response.body().charStream(), City.class);
            list = city.getObj();
            adapter = new CityAdapter(mContext, list);
//            在主线程中改变UI
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listView.setAdapter(adapter);
                }
            });
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.location_city:
                Intent intent=new Intent(this,MapActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 动态设置ListView的高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
