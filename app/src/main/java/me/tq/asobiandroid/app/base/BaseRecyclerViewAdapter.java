package me.tq.asobiandroid.app.base;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author:Tianqi
 * date:2019/3/17
 */
public abstract class BaseRecyclerViewAdapter<V> extends BaseQuickAdapter<V, BaseViewHolder> {

    public BaseRecyclerViewAdapter(int layoutResId, @Nullable List<V> data) {
        super(layoutResId, data);
    }

    public BaseRecyclerViewAdapter(@Nullable List<V> data) {
        super(data);
    }

    public BaseRecyclerViewAdapter(int layoutResId) {
        super(layoutResId);
    }

}
