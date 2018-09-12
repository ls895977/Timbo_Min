package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.lishan.timbo_min.R;

import java.util.List;

/**
 * Created by lishan on 2017/12/21.
 */

public class ProblemGridAdapter extends BaseAdapter {
    List<String> str;
    private Context context;

    public void setStr(List<String> str) {
        this.str = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public Object getItem(int i) {
        return str.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_problem,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        return view;
    }

    private class ViewHolder {
        private ImageView myImageView;
        public ViewHolder(View v) {
            myImageView = (ImageView) v.findViewById(R.id.round_imageview1);
        }
    }

}
