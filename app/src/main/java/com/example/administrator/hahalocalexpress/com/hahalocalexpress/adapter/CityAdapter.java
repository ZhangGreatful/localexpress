package com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class CityAdapter extends BaseAdapter {
    private Context mContext;
    private List<Object> mList=new ArrayList<>();
    private LayoutInflater inflater;

    public CityAdapter(Context context, List<Object> list) {
        this.mContext = context;
        this.mList = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            view = inflater.inflate(R.layout.city_list_item, null);
            viewHolder=new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.city_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(mList.get(position).getCity_name());
        return view;
    }

    private class ViewHolder {
        TextView textView;
    }
}
