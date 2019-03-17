package me.tq.asobiandroid.arch.net;

import io.reactivex.observers.ResourceObserver;
import me.tq.asobiandroid.arch.mvp.IView;

/**
 * author:Tianqi
 * date:2019/3/17
 */
public abstract class AResponseObserver<T> extends ResourceObserver<T> {

    private IView mView;
    private String mErrorMessage;
    private boolean isShowError;

    public AResponseObserver(IView mView) {
        this.mView = mView;
    }

    public AResponseObserver(IView mView, String mErrorMessage) {
        this.mView = mView;
        this.mErrorMessage = mErrorMessage;
    }

    public AResponseObserver(IView mView, String mErrorMessage, boolean isShowError) {
        this.mView = mView;
        this.mErrorMessage = mErrorMessage;
        this.isShowError = isShowError;
    }

    @Override
    public void onError(Throwable e) {
        if(!isShowError || mView != null) {
            mView.showErrorMessage(mErrorMessage);
        }
    }

    @Override
    protected void onStart() {

    }

    @Override
    public void onComplete() {

    }

}
