package me.tq.asobiandroid.app.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.tq.asobiandroid.arch.mvp.IPresenter;
import me.tq.asobiandroid.arch.mvp.IView;
import me.tq.asobiandroid.arch.mvp.base.BasePresenter;
import me.tq.asobiandroid.utils.Injection;

/**
 * author:Tianqi
 * date:2019/3/16
 */
@SuppressLint("Registered")
public class BaseViewActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void showError() {

    }

    @Override
    public void showErrorMessage(String error) {

    }

    @Override
    public void reload() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
