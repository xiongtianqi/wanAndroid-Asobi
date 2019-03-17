package me.tq.asobiandroid.app.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.tq.asobiandroid.app.base.BaseViewFragment;
import me.tq.asobiandroid.arch.mvp.contract.MainContract;
import me.tq.asobiandroid.arch.net.main.MainArticle;
import me.tq.asobiandroid.arch.net.main.MainArticleList;

/**
 * author:Tianqi
 * date:2019/3/17
 */
public class MainFragment extends BaseViewFragment<MainPresenter> implements MainContract.View {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void reloadArticleList(MainArticleList mainArticleList) {

    }

    @Override
    public void reloadArticle(List<MainArticle> mainArticles) {

    }
}
