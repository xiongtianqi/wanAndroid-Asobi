package me.tq.asobiandroid.arch.net;

import io.reactivex.Observable;
import me.tq.asobiandroid.arch.net.main.MainArticleList;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ANetApi {

    @GET("article/list/{page}/json")
    Observable<AResponse<MainArticleList>> getMainArticleList(@Path("page") int page);
}
