package me.tq.asobiandroid.arch.db;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public class ADatabaseRepository {
    private static class InstanceHolder {
        private static ADatabaseRepository instance = new ADatabaseRepository();
    }

    private ADatabaseRepository() {

    }

    public static ADatabaseRepository get() {
        return InstanceHolder.instance;
    }
}
