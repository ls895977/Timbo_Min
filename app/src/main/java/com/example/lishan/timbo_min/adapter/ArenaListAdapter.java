package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.CreateaplaBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lishan on 2017/12/18.
 */

public class ArenaListAdapter extends RecyclerView.Adapter<ArenaListAdapter.MyViewHolder> {
    private Context context;
    private List<ArenaBean.DataBean> datas;
    private BackButtonClick backButtonClick;

    public ArenaListAdapter(BackButtonClick backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<ArenaBean.DataBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_arena, parent, false));
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
        holder.arena_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.arenabutton(position);
            }
        });
        ArenaBean.DataBean item = datas.get(position);
        holder.title.setText(item.getType_name());
        Glide.with(context).load(item.getLz().getJoin_url()).into(holder.arena_button);
        Glide.with(context).load(item.getUser().getHeadimg()).into(holder.haderimage);
        holder.name.setText(item.getUser().getName() + " " + item.getUser().getAge());
        holder.num.setText("参与人数："+item.getLz().getComment_num());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView myClick, title, name,num;
        private ImageView arena_button;
        private de.hdodenhof.circleimageview.CircleImageView haderimage;

        public MyViewHolder(View itemView) {
            super(itemView);
            myClick = (TextView) itemView.findViewById(R.id.item_arenatonclick);
            arena_button = (ImageView) itemView.findViewById(R.id.arena_hader);
            title = (TextView) itemView.findViewById(R.id.item_arena_title);
            haderimage = (CircleImageView) itemView.findViewById(R.id.item_profile_image);
            name = (TextView) itemView.findViewById(R.id.item_profile_name);
            num= (TextView) itemView.findViewById(R.id.item_profile_num);
        }
    }

    public interface BackButtonClick {
        void backClcik(int indext);

        void arenabutton(int indext);
    }
}

