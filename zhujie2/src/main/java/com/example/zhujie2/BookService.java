package com.example.zhujie2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class BookService {

    private Retrofit mRetrofit;
    private BookHttp mhttp;

    public BookService() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.247.113:8080/WebSample/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        mhttp = mRetrofit.create(BookHttp.class);
    }

   public Call<String> getDatil(int id)
   {

       return mhttp.getDatil(id);
   }
}
