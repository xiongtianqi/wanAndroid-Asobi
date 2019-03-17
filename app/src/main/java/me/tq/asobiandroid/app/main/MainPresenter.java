package me.tq.asobiandroid.app.main;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import me.tq.asobiandroid.arch.mvp.base.BasePresenter;
import me.tq.asobiandroid.arch.mvp.contract.MainContract;
import me.tq.asobiandroid.arch.net.AResponse;
import me.tq.asobiandroid.arch.net.AResponseObserver;
import me.tq.asobiandroid.arch.net.main.MainArticle;
import me.tq.asobiandroid.arch.net.main.MainArticleList;
import me.tq.asobiandroid.data.DataManager;
import me.tq.asobiandroid.utils.RxUtils;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void setCurrentPage(int page) {
        mDataManager.getMainArticleList(page)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribe(new AResponseObserver<MainArticleList>(mView) {
                    @Override
                    public void onNext(MainArticleList mainArticleList) {
                        mView.reloadArticleList(mainArticleList);
                    }
                });
    }

}
