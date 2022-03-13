package org.libtlauncher.toolbox.Utils.pluginUtil.base;

import android.util.SparseArray;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    //用于保存view避免重复findView 的稀疏数组
    private SparseArray<View> mView;

    private Context context;

    private View mConvertView;

    public ViewHolder(View view,Context context){
        super(view);
        mView=new SparseArray<View>();
        this.context=context;
        this.mConvertView=view;
    }

    public static ViewHolder getViewHolder(Context context,ViewGroup parent,int layoutId){
        View view=LayoutInflater.from(context).inflate(layoutId,parent,false);
        ViewHolder holder=new ViewHolder(view,context);
        return holder;
    }

    public <T extends View> T getView(int viewId){
        View view=mView.get(viewId);
        if(view==null){
            view=mConvertView.findViewById(viewId);
            mView.put(viewId,view);
        }
        return (T) view;
    }

}
