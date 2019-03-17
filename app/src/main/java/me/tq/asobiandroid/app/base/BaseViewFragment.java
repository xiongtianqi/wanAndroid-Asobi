package me.tq.asobiandroid.app.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import me.tq.asobiandroid.arch.mvp.IPresenter;
import me.tq.asobiandroid.arch.mvp.IView;

/**
 * author:Tianqi
 * date:2019/3/17
 */
public class BaseViewFragment<T extends IPresenter> extends Fragment implements IView {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter = null;
        }
        super.onDetach();
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
