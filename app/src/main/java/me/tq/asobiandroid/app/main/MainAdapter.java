package me.tq.asobiandroid.app.main;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import me.tq.asobiandroid.R;
import me.tq.asobiandroid.app.base.BaseRecyclerViewAdapter;
import me.tq.asobiandroid.arch.net.main.MainArticle;

/**
 * author:Tianqi
 * date:2019/3/17
 */
public class MainAdapter extends BaseRecyclerViewAdapter<MainArticle> {

    public MainAdapter(List<MainArticle> list) {
        super(R.layout.item_main, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainArticle item) {
        /*Glide.with(mContext)
                .load(item.getEnvelopepic())
                .apply(RequestOptions.centerCropTransform())
                .into((ImageView) helper.getView(R.id.iv_main));*/

        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_author, item.getAuthor())
                .setText(R.id.tv_time, item.getNicedate());
    }
}
