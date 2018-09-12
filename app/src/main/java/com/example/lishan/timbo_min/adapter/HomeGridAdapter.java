package com.example.lishan.timbo_min.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CollectionBean;
import com.example.lishan.timbo_min.bean.HomGrdBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class HomeGridAdapter extends RecyclerView.Adapter<HomeGridAdapter.ViewHolder> {


    public List<HomGrdBean> datas = null;
    private backItem backItem;

    public HomeGridAdapter(List<HomGrdBean> datas, backItem onbackitem) {
        this.datas = datas;
        this.backItem = onbackitem;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public HomeGridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_homegridview, viewGroup, false);
        return new HomeGridAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(HomeGridAdapter.ViewHolder viewHolder, final int position) {
    }

    @Override
    public void onBindViewHolder(HomeGridAdapter.ViewHolder holder, final int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        HomGrdBean item = datas.get(position);
        holder.myText.setText(item.getName());
        holder.myimage.setImageResource(item.getImages());
        holder.myimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backItem.OnBackItem(position);
            }
        });

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView myimage;
        TextView myText;

        public ViewHolder(View view) {
            super(view);
            myimage = (ImageView) itemView.findViewById(R.id.item_homegrdimage);
            myText = (TextView) itemView.findViewById(R.id.item_homegrdname);
        }
    }

    public interface backItem {
        void OnBackItem(int position);
    }
}






















