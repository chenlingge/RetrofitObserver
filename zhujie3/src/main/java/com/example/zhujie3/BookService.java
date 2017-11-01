package com.example.zhujie3;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class BookService {

    private Retrofit mRetrofit;
    private BookHttp mhttp;

    public BookService() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.181.49:8080/WebSample/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mhttp = mRetrofit.create(BookHttp.class);
    }

    public Observable<BookEntity> getDatil(int id) {

        return mhttp.getDatil(id);
    }
}
