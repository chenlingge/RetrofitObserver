package com.example.chenlingge20171026;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.okutil.OkHttp3Utils;
import com.example.chenlingge20171026.adapter.MyAdapter;
import com.example.chenlingge20171026.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类的名称：主界面
 * 类的作用：展示主界面内容
 * 类的作者：陈令鸽
 * 类的日期：2017.10.26
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //调用方法
        initData();
    }

    //获取资源ID
    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

    }

    //获取网络数据
    private void initData() {

        OkHttp3Utils.doGet("http://huixinguiyu.cn/Assets/js/data.js", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String s = response.body().string();
                System.out.println("********" + s + "*******");
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.ApkBean> apk = bean.getApk();
                //设置线性布局样式
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recyclerview.setLayoutManager(manager);
                //创建并关联适配器
                adapter = new MyAdapter(MainActivity.this, apk);
                recyclerview.setAdapter(adapter);
                adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    }
                });
            }
        });
    }
}

