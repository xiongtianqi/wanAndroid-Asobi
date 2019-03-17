package me.tq.asobiandroid.data;

import io.reactivex.Observable;
import me.tq.asobiandroid.arch.db.ADatabaseRepository;
import me.tq.asobiandroid.arch.net.ANetRepository;
import me.tq.asobiandroid.arch.net.AResponse;
import me.tq.asobiandroid.arch.net.main.MainArticleList;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public class DataManager {

    private static class InstanceHolder {
        private static DataManager instance = new DataManager();
    }

    private ANetRepository netRepository;

    private ADatabaseRepository databaseRepository;

    private DataManager() {
        netRepository = ANetRepository.get();
        databaseRepository = ADatabaseRepository.get();
    }

    public static DataManager get() {
        return InstanceHolder.instance;
    }

    public Observable<AResponse<MainArticleList>> getMainArticleList(int page) {
        return netRepository.getMainArticleList(page);
    }


}
