package me.tq.asobiandroid.utils;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.tq.asobiandroid.arch.net.AResponse;
import me.tq.asobiandroid.exception.OtherException;

public class RxUtils {

    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<AResponse<T>, T> handleResult() {
        return new ObservableTransformer<AResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<AResponse<T>> upstream) {
                return upstream.flatMap(new Function<AResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(AResponse<T> taResponse) throws Exception {
                        if(taResponse.getErrorCode() == AResponse.CODE_SUCCESS &&
                                taResponse.getData() != null) {
                            return createData(taResponse.getData());
                        } else {
                            return Observable.error(new OtherException());
                        }
                    }
                });
            }
        };
    }

    static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                    e.printStackTrace();
                }
            }
        });
    }
}
