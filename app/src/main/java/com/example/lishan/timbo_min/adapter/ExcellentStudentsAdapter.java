package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;
import com.example.lishan.timbo_min.bean.ExcellentStudentsBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/24.
 */

public class ExcellentStudentsAdapter extends RecyclerView.Adapter<ExcellentStudentsAdapter.MyViewHolder> {
    private Context context;
    private List<ExcellentStudentsBean> datas;
    private ArenaDetalListAdapter.BackButtonClick1 backButtonClick;

//    public ExcellentStudentsAdapter(ArenaDetalListAdapter.BackButtonClick1 backButtonClick1) {
//        this.backButtonClick = backButtonClick1;
//    }

    public void setDatas(List<ExcellentStudentsBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExcellentStudentsAdapter.MyViewHolder viewHolder = new ExcellentStudentsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_excellentstudents, parent, false));
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
        private TextView myClick;
        private ImageView arena_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            myClick = (TextView) itemView.findViewById(R.id.arenadetaill_message);
        }
    }

    public interface BackButtonClick1 {
        void backClcik(int indext);

        void arenabutton(int indext);
    }
}