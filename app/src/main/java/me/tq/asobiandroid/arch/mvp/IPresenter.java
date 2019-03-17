package me.tq.asobiandroid.arch.mvp;

import io.reactivex.disposables.Disposable;

public interface IPresenter<V extends IView> {

    void attachView(V view);

    void detachView();

    void addRxSubscribe(Disposable disposable);
}
