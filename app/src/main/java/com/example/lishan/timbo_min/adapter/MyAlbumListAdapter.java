package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.MyAlbumBean;
import com.example.lishan.timbo_min.bean.MyEssayBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class MyAlbumListAdapter extends RecyclerView.Adapter<MyAlbumListAdapter.MyViewHolder> {
    private ObackItem MyObackItem;
    private Context context;
    private List<MyAlbumBean> datas;

    public MyAlbumListAdapter(ObackItem MyObackItem1) {
        this.MyObackItem = MyObackItem1;
    }

    public void setDatas(List<MyAlbumBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_myalbum, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.haderImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyObackItem.itemImage(position);
            }
        });

        holder.itemAlbumMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyObackItem.itemMessage(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemAlbumMessage;
        private ImageView haderImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemAlbumMessage = (TextView) itemView.findViewById(R.id.itemAlbumMessage);
            haderImage = (ImageView) itemView.findViewById(R.id.itemAlbumHader);
        }
    }

    public interface ObackItem {
        void itemMessage(int position);

        void itemImage(int position);
    }
}

