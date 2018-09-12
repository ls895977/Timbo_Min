package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.GrowthActivityBean;
import com.example.lishan.timbo_min.bean.MyEssayBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class GrowthActivityListAdapter extends RecyclerView.Adapter<GrowthActivityListAdapter.MyViewHolder> {
    private Context context;
    private List<GrowthActivityBean> datas;
    public void setDatas(List<GrowthActivityBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_growthacitivity, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

