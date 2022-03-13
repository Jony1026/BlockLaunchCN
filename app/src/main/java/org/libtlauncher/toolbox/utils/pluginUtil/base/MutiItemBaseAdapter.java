package org.libtlauncher.toolbox.Utils.pluginUtil.base;

import android.content.Context;
import android.view.ViewGroup;

public abstract class MutiItemBaseAdapter<T> extends RecyclerBaseAdapter<T> {

    public MutiItemBaseAdapter(Context ctx) {
        super(ctx,-1);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, (T) items.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getLayoutId(viewType);
        ViewHolder holder = ViewHolder.getViewHolder(context, parent, layoutId);
        return holder;
    }

    public abstract int getLayoutId(int itemType);
    public abstract int getItemViewType(int position, T t);


}
