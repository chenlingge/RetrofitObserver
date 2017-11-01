package com.example.zhujie;

import com.bwie.okutil.OkHttp3Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 陈令鸽 on 2017/10/31.
 */

public class Http {
    @Url("http://api.juheapi.com/japi/toh?key=f1f46c8bc1fe10a32548528512abb082&v=1.0&month=11&day=1")
    public String s;


    public Http(){
        Field[] fields = Http.class.getDeclaredFields();
        for(Field f:fields){
            Url url = f.getAnnotation(Url.class);
            s = url.value();
            System.out.print(s);
        }
        OkHttp3Utils.doGet(s, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                List<Bean.ResultBean> result = bean.getResult();
                System.out.print(result);
            }
        });

    }

}
