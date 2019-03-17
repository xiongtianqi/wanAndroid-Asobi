package me.tq.asobiandroid.arch.mvp.contract;

import java.util.List;

import me.tq.asobiandroid.arch.mvp.IPresenter;
import me.tq.asobiandroid.arch.mvp.IView;
import me.tq.asobiandroid.arch.net.main.MainArticle;
import me.tq.asobiandroid.arch.net.main.MainArticleList;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public interface MainContract {

    interface View extends IView {

        void reloadArticleList(MainArticleList mainArticleList);

        void reloadArticle(List<MainArticle> mainArticles);



    }

    interface Presenter extends IPresenter<View> {

        void setCurrentPage(int page);

    }
}
