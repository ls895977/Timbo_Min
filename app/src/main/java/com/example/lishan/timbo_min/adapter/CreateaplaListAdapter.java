package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CreateaplaBean;
import com.example.lishan.timbo_min.bean.GrowthActivityBean;
import com.example.lishan.timbo_min.common.MyTooL;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class CreateaplaListAdapter extends RecyclerView.Adapter<CreateaplaListAdapter.MyViewHolder> {
    private Context context;
    private List<CreateaplaBean.PlansBean> datas;
    private BackButtonClick backButtonClick;

    public CreateaplaListAdapter(BackButtonClick backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<CreateaplaBean.PlansBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_createapla, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.shudow.setOnClickListener(new View.OnClickListener() {//删除
            @Override
            public void onClick(View view) {
                backButtonClick.OnShutdow(position);
            }
        });
        holder.shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.Onshezhi(position);
            }
        });
        CreateaplaBean.PlansBean itme = datas.get(position);
        if (itme.isQiyong()) {
            holder.mycheck.setSelected(true);
        } else {
            holder.mycheck.setSelected(false);
        }
        holder.mycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.OnChebox(position);
            }
        });
        if (position == datas.size() - 1 || datas.size() == 1) {
            holder.myLiayout.setVisibility(View.GONE);
            holder.item_createapla_addl.setVisibility(View.VISIBLE);
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backButtonClick.Ondaka();
                }
            });
        } else {
            holder.item_createapla_addl.setVisibility(View.GONE);
            holder.myLiayout.setVisibility(View.VISIBLE);
            holder.date.setText("创建:" + MyTooL.getStandardDate(itme.getCreatetime()));
            holder.title.setText(itme.getName());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView shudow, shezhi, add;
        private TextView mycheck, title, date;
        private LinearLayout myLiayout, item_createapla_addl;

        public MyViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.item_createapla_date);
            title = (TextView) itemView.findViewById(R.id.item_createapla_title);
            shudow = (ImageView) itemView.findViewById(R.id.item_createapla_shudown);
            shezhi = (ImageView) itemView.findViewById(R.id.item_createapla_shezhi);
            mycheck = (TextView) itemView.findViewById(R.id.myCreateaplan_tv);
            add = (ImageView) itemView.findViewById(R.id.item_createapla_add);
            myLiayout = (LinearLayout) itemView.findViewById(R.id.myitemcrate);
            item_createapla_addl = (LinearLayout) itemView.findViewById(R.id.item_createapla_addl);
        }
    }

    public interface BackButtonClick {
        void OnShutdow(int position);

        void Onshezhi(int position);

        void Ondaka();

        void OnChebox(int position);
    }
}

