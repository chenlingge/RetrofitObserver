package com.example.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;
    private User user;
    private TextView mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();

        user = new User((long) 2, "hahahahhaahhahahahahaah");
        mUserDao.insert(user);//添加一个

        // mUserDao.deleteByKey(id);

        user = new User((long) 2, "wuwuwuwuwuwuwuwuwuuw");
        mUserDao.update(user);


        List<User> users = mUserDao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName() + ",";
        }
        mContext.setText("查询全部数据==>" + userName);


    }

    private void initView() {
        mContext = (TextView) findViewById(R.id.mContext);
    }
}
