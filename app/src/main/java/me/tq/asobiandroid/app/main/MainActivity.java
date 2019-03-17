package me.tq.asobiandroid.app.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.tq.asobiandroid.R;
import me.tq.asobiandroid.app.base.BaseViewActivity;
import me.tq.asobiandroid.arch.mvp.contract.MainContract;
import me.tq.asobiandroid.arch.net.ANetRepository;
import me.tq.asobiandroid.arch.net.AResponse;
import me.tq.asobiandroid.arch.net.main.MainArticle;
import me.tq.asobiandroid.arch.net.main.MainArticleList;
import me.tq.asobiandroid.utils.Injection;
import me.tq.asobiandroid.utils.RxUtils;

public class MainActivity extends BaseViewActivity<MainContract.Presenter> implements MainContract.View {

    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;


    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = Injection.getPresenter(MainPresenter.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        findViewById(R.id.btn_connect).setOnClickListener(v -> {
            mPresenter.setCurrentPage(i++);
        });
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_main);
        mAdapter = new MainAdapter(null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void reloadArticleList(MainArticleList mainArticleList) {
        reloadArticle(mainArticleList.getDatas());
    }

    @Override
    public void reloadArticle(List<MainArticle> mainArticles) {
        mAdapter.setNewData(mainArticles);
    }
}
