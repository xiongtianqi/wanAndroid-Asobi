package me.tq.asobiandroid.arch.mvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import me.tq.asobiandroid.arch.mvp.IPresenter;
import me.tq.asobiandroid.arch.mvp.IView;
import me.tq.asobiandroid.data.DataManager;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;
    protected DataManager mDataManager;

    private CompositeDisposable compositeDisposable;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        if(compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void addRxSubscribe(Disposable disposable) {
        if(compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
