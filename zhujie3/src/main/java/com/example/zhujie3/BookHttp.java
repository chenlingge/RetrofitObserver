package com.example.zhujie3;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface BookHttp {

    @GET("action/book_detail")
    Observable<BookEntity> getDatil(@Query("id") int id);
}
