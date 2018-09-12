package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lishan on 2017/12/18.
 */

public class ArenaDetalListAdapter extends RecyclerView.Adapter<ArenaDetalListAdapter.MyViewHolder> {
    private Context context;
    private List<ArenaDetalBean.DataBean.PkRecordDataBean> datas;
    private BackButtonClick1 backButtonClick;

    public ArenaDetalListAdapter(BackButtonClick1 backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<ArenaDetalBean.DataBean.PkRecordDataBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_arenadetall, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.myClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.backClcik(position);
            }
        });
        ArenaDetalBean.DataBean.PkRecordDataBean item = datas.get(position);
        if(item.getJoin_url()!=null) {
            Glide.with(context).load(item.getJoin_url()).into(holder.arena_button);
        }
        if(item.getUser().getHeadimg()!=null) {
            Glide.with(context).load(item.getUser().getHeadimg()).into(holder.hader);
        }
        holder.name.setText("挑战者：" + item.getUser().getName());
        holder.age.setText(item.getUser().getAge() + "岁");
        holder.context.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView myClick, name, age, context;
        private ImageView arena_button;
        private de.hdodenhof.circleimageview.CircleImageView hader;

        public MyViewHolder(View itemView) {
            super(itemView);
            myClick = (TextView) itemView.findViewById(R.id.arenadetaill_message111);
            arena_button = (ImageView) itemView.findViewById(R.id.arena_button11111);
            hader = (CircleImageView) itemView.findViewById(R.id.item_profile_image111);
            name = (TextView) itemView.findViewById(R.id.item_arenadetall_name);
            age = (TextView) itemView.findViewById(R.id.item_arenadetall_age);
            context = (TextView) itemView.findViewById(R.id.item_arenadetall_context);
        }
    }

    public interface BackButtonClick1 {
        void backClcik(int indext);

        void arenabutton(int indext);
    }
}

