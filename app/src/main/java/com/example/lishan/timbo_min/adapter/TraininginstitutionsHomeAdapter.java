package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.OurTeamBean;
import com.example.lishan.timbo_min.bean.TraininginstitutionsHomeBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/24.
 */

public class TraininginstitutionsHomeAdapter extends RecyclerView.Adapter<TraininginstitutionsHomeAdapter.MyViewHolder> {
    private Context context;
    private List<TraininginstitutionsHomeBean> datas;
    private onBackItem backButtonClick;

    public TraininginstitutionsHomeAdapter(onBackItem backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<TraininginstitutionsHomeBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public TraininginstitutionsHomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TraininginstitutionsHomeAdapter.MyViewHolder viewHolder = new TraininginstitutionsHomeAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_traininginstitutionshome, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.myLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.onItem(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout myLi;

        public MyViewHolder(View itemView) {
            super(itemView);
            myLi = (LinearLayout) itemView.findViewById(R.id.traininginstitutionsHome);
        }

    }

    public interface onBackItem {

        void onItem(int position);
    }
}
