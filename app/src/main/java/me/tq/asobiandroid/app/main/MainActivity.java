package me.tq.asobiandroid.app.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.tq.asobiandroid.R;
import me.tq.asobiandroid.arch.net.ANetRepository;
import me.tq.asobiandroid.arch.net.AResponse;
import me.tq.asobiandroid.arch.net.main.MainArticleList;
import me.tq.asobiandroid.utils.RxUtils;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_tmp);
        findViewById(R.id.btn_connect).setOnClickListener(v -> {
            ANetRepository.get().getMainArticleList(i++).compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new Observer<AResponse<MainArticleList>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(AResponse<MainArticleList> mainArticleListAResponse) {
                            System.out.print(mainArticleListAResponse);
                            textView.setText(mainArticleListAResponse.toString());
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.out.print(e.toString());
                            textView.setText(e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
    }
}
