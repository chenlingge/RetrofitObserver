package com.example.zhujie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        Http http = new Http();
        String s = http.s.toString();
        Toast.makeText(MainActivity.this,"sss"+s,Toast.LENGTH_LONG).show();
//        OkHttp3Utils.doGet(s, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                Gson gson=new Gson();
//                Bean bean = gson.fromJson(string, Bean.class);
//                List<Bean.ResultBean> result = bean.getResult();
//                System.out.print(result);
//            }
//        });
    }
}
