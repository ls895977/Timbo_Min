package com.lykj.aextreme.afinal.adapter;

/**
 * Adapter的Item点击事件监听
 */
public class ViewOnLongClick implements android.view.View.OnLongClickListener {
    Object obj;
    int position;
    IAdapterListener listener;
    public static final int LONG_CLICK = 100;

    public ViewOnLongClick(IAdapterListener listener, Object obj, int position) {
        this.obj = obj;
        this.position = position;
        this.listener = listener;
    }

    @Override
    public boolean onLongClick(android.view.View v) {
        if (listener != null) {
            listener.onViewClick(LONG_CLICK, obj, position);

        }
        return false;
    }

}