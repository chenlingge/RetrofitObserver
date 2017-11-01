package com.example.zhujie2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvDtCreated;
    private TextView mTvDescription;
   // public static final String URL="http://169.254.247.113:8080/WebSample/action/book_detail?id=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        RXJson();

    }

    private void RXJson() {
        /**
         * 观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String bookEntity) {
                BookEntity entity = new Gson().fromJson(bookEntity, BookEntity.class);

                mTvTitle.setText(entity.getData().getTitle());
                mTvDtCreated.setText(entity.getData().getDtCreated());
                mTvDescription.setText(entity.getData().getDescription());
            }
        };


        /**
         * 被观察者
         */
        Observable.OnSubscribe<String> observable = new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {

                BookService service = new BookService();
                Call<String> call = service.getDatil(3);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        //BookEntity entity = new Gson().fromJson(response.body(), BookEntity.class);
                        subscriber.onNext(response.body());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        subscriber.onError(t);

                    }
                });

            }
        };
        Observable.create(observable).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);

    }


    //获取资源ID
    private void initView() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvDtCreated = (TextView) findViewById(R.id.tv_dt_created);
        mTvDescription = (TextView) findViewById(R.id.tv_description);
    }
}
