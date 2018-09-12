package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.example.lishan.timbo_min.bean.MemberBean;
import com.lykj.aextreme.afinal.adapter.BaseAdapter;

import java.util.List;

/**
 * Created by lishan on 2017/12/10.
 */

public class MemberGridAdapter extends BaseAdapter {
    List<MemberBean> datas;

    public MemberGridAdapter(Context context, List<MemberBean> datass) {
        super(context);
        this.datas=datass;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflate(R.layout.item_member, null);
            viewHolder = new ViewHolder();
            viewHolder.myimage = (ImageView) convertView.findViewById(R.id.item_homegrdimage);
            viewHolder.myText = (TextView) convertView.findViewById(R.id.item_homegrdname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MemberBean data=datas.get(i);
        viewHolder.myText.setText(data.getTitle());
        viewHolder.myimage.setImageResource(data.getImgs());
        return convertView;
    }

    private class ViewHolder {
        ImageView myimage;
        TextView myText;
    }
}
