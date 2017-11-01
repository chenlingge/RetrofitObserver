package com.example.zhujie3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
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
        Observer<BookEntity> observer = new Observer<BookEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BookEntity bookEntity) {

                mTvTitle.setText(bookEntity.getData().getTitle());
                mTvDtCreated.setText(bookEntity.getData().getDtCreated());
                mTvDescription.setText(bookEntity.getData().getDescription());
            }
        };

//        Observable<BookEntity> observable = Observable.create(new Observable.OnSubscribe<BookEntity>() {
//            @Override
//            public void call(final Subscriber<? super BookEntity> subscriber) {
//
//
//                new BookService().getDatil(3).enqueue(new Callback<BookEntity>() {
//                    @Override
//                    public void onResponse(Call<BookEntity> call, Response<BookEntity> response) {
//
//
//                        System.out.println("----" + response.body().getErrMsg());
//                        subscriber.onNext(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<BookEntity> call, Throwable t) {
//
//
//                        System.out.println("--请求失败--");
//                    }
//                });
//            }
//        });

        Observable<BookEntity> observable = new BookService().getDatil(3);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }


    //获取资源ID
    private void initView() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvDtCreated = (TextView) findViewById(R.id.tv_dt_created);
        mTvDescription = (TextView) findViewById(R.id.tv_description);
    }
}
