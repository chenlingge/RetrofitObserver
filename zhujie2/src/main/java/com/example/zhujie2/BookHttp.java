package com.example.zhujie2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 陈令鸽 on 2017/11/1.
 */

public interface BookHttp {

    @GET("action/book_detail")
    Call<String> getDatil(@Query("id") int id);
}
