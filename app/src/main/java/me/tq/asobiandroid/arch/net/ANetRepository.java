package me.tq.asobiandroid.arch.net;

import io.reactivex.Observable;
import me.tq.asobiandroid.arch.net.main.MainArticleList;
import me.tq.asobiandroid.currency.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ANetRepository {

    private static class InstanceHolder {
        private static ANetRepository instance = new ANetRepository();
    }

    private ANetApi netApi;

    private ANetRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        netApi = retrofit.create(ANetApi.class);
    }

    public static ANetRepository get() {
        return InstanceHolder.instance;
    }

    public Observable<AResponse<MainArticleList>> getMainArticleList(int page) {
        return netApi.getMainArticleList(page);
    }
}
