package org.libtlauncher.toolbox.Utils.pluginUtil.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerBaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context context;
    protected int layoutId;
    protected List items;
    private boolean isTap;
    private long stTime;
    private long duration=336;
    private boolean isDoubleTap;
    protected OnItemClickListener itemClickListener;


    public RecyclerBaseAdapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public OnItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = ViewHolder.getViewHolder(context, parent, layoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        convert(holder, (T) items.get(position), getItemViewType(position));

        if (itemClickListener != null) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final int pos = holder.getLayoutPosition();
                    if(!isTap){
                        isTap=true;
                        isDoubleTap=false;
                        stTime=System.currentTimeMillis();
                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                if(!isDoubleTap){
                                    itemClickListener.onItemClickListener(v,pos);
                                    isTap=false;
                                }else{
                                    itemClickListener.onItemDoubleTapListener(v,pos);
                                }
                            }
                        },duration);
                    }else if(isTap){
                        long cur=System.currentTimeMillis();
                        if((cur-stTime)<=duration){
                            isDoubleTap=true;
                            isTap=false;
                        }
                    }


                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    itemClickListener.onItemLongClickListener(holder.itemView, pos);
                    return true;
                }
            });

        }
    }
    public abstract void convert(ViewHolder holder, T t, int viewType);

    @Override
    public int getItemCount() {
        if (items == null || items.size() == 0) {
            return 0;
        }
        return items.size();
    }

    public List getItems() {
        return items;
    }

    public void setItems(List is) {
        this.items = is;
    }



    public interface OnItemClickListener{
        void onItemClickListener(View view,int position);
        void onItemLongClickListener(View view,int position);
        void onItemDoubleTapListener(View view,int position);
    }
}
