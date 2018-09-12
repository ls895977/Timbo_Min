package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.OurTeamBean;
import com.example.lishan.timbo_min.bean.TraininginstitutionsTuanduiBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/24.
 */

public class OurTeamAdapter extends RecyclerView.Adapter<OurTeamAdapter.MyViewHolder> {
    private Context context;
    private List<OurTeamBean> datas;
    private ArenaDetalListAdapter.BackButtonClick1 backButtonClick;
//
//    public TraininginstitutionsTuanduiAdapter(ArenaDetalListAdapter.BackButtonClick1 backButtonClick1) {
//        this.backButtonClick = backButtonClick1;
//    }

    public void setDatas(List<OurTeamBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public OurTeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        OurTeamAdapter.MyViewHolder viewHolder = new OurTeamAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ourteam, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

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
