package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;
import com.example.lishan.timbo_min.bean.MyClassBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.MyViewHolder> {
    private Context context;
    private List<MyClassBean> datas;
    private BackButtonClick1 backButtonClick;
    public MyClassAdapter(BackButtonClick1 backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<MyClassBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_myclass, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MyClassBean item = datas.get(position);
        switch (item.getBack()) {
            case 0://运动
                holder.reback.setBackgroundResource(R.mipmap.icon_d1);
                break;
            case 1://竞技场
                holder.reback.setBackgroundResource(R.mipmap.icon_jing);
                break;
            case 2://成长
                holder.reback.setBackgroundResource(R.mipmap.icon_zhang);
                break;
            case 3://晒技能
                holder.reback.setBackgroundResource(R.mipmap.icon_shai);
                break;
            case 4://活动
                holder.reback.setBackgroundResource(R.mipmap.icon_huo);
                break;
        }
        holder.reback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.backItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RelativeLayout reback;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_myclass_title);
            reback = (RelativeLayout) itemView.findViewById(R.id.item_myclass_back);
        }
    }

    public interface BackButtonClick1 {
        void backItem(int indext);
    }
}

