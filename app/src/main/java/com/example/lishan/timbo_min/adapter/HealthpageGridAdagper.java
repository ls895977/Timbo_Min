package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.HealthpageGridBean;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.lykj.aextreme.afinal.adapter.BaseAdapter;

import java.util.List;

/**
 * Created by lishan on 2017/12/17.
 */

public class HealthpageGridAdagper extends BaseAdapter {
    List<HealthpageGridBean.DataBean> datas;

    public void setDatas(List<HealthpageGridBean.DataBean> datas) {
        this.datas = datas;
    }

    public HealthpageGridAdagper(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        VIewHolder vIewHolder;
        if (convertView == null) {
            convertView = inflate(R.layout.item_healthpagegrid, null);
            vIewHolder = new VIewHolder(convertView);
            convertView.setTag(vIewHolder);
        } else {
            vIewHolder = (VIewHolder) convertView.getTag();
        }
        HealthpageGridBean.DataBean item = datas.get(i);
        vIewHolder.name.setText(item.getCate_name());
        Glide.with(getContext()).load(item.getImg()).placeholder(R.mipmap.icon_xx).into(vIewHolder.image);
        return convertView;
    }

    class VIewHolder {
        private ImageView image;
        private TextView name;

        public VIewHolder(View v) {
            image = (ImageView) v.findViewById(R.id.item_healthpagergrid1);
            name = (TextView) v.findViewById(R.id.item_healthpagergrid2);
        }
    }
}
