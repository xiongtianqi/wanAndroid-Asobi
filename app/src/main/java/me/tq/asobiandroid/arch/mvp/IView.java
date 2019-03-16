package me.tq.asobiandroid.arch.mvp;

public interface IView {

    void showError();

    void showErrorMessage(String error);

    void reload();

    void showLoading();

    void hideLoading();
}
