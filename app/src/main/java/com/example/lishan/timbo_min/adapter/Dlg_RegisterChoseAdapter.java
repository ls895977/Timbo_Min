package com.example.lishan.timbo_min.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ClassroomBean;
import com.example.lishan.timbo_min.bean.Dlg_RegisterChoseBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class Dlg_RegisterChoseAdapter extends RecyclerView.Adapter<Dlg_RegisterChoseAdapter.ViewHolder> {
    public List<Dlg_RegisterChoseBean.DataBean> datas = null;
    private onBackItem onBackItem;

    public Dlg_RegisterChoseAdapter(List<Dlg_RegisterChoseBean.DataBean> datas, onBackItem onBackItem1) {
        this.datas = datas;
        this.onBackItem = onBackItem1;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public Dlg_RegisterChoseAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_registerchose, viewGroup, false);
        return new Dlg_RegisterChoseAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(Dlg_RegisterChoseAdapter.ViewHolder viewHolder, final int position) {
        Dlg_RegisterChoseBean.DataBean dataBean = datas.get(position);
        if (dataBean.isStatus()) {
            viewHolder.item1.setVisibility(View.VISIBLE);
            viewHolder.item2.setVisibility(View.GONE);
            viewHolder.name1.setText(dataBean.getSchool_name());
        } else {
            viewHolder.item1.setVisibility(View.GONE);
            viewHolder.item2.setVisibility(View.VISIBLE);
            viewHolder.name2.setText(dataBean.getSchool_name());
        }
        viewHolder.myLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackItem.onBackType(position);
            }
        });
        viewHolder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackItem.onClickChose(position);
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
        public TextView name1, name2, click;

        public RelativeLayout item1, item2;
        public LinearLayout myLiner;

        public ViewHolder(View view) {
            super(view);
            item1 = (RelativeLayout) view.findViewById(R.id.item_registerchose1);
            item2 = (RelativeLayout) view.findViewById(R.id.item_registerchose2);
            name1 = (TextView) view.findViewById(R.id.item_registerchose_name1);
            name2 = (TextView) view.findViewById(R.id.item_registerchose_name2);
            click = (TextView) view.findViewById(R.id.item_choseOnclick);
            myLiner = (LinearLayout) view.findViewById(R.id.registerchose_item);
        }
    }


    public interface onBackItem {
        void onBackType(int position);

        void onClickChose(int position);
    }
}






















