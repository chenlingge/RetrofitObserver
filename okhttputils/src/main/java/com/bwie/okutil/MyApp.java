package com.bwie.okutil;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class MyApp extends Application {
    public static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        String path = Environment.getExternalStorageDirectory() + "/1507B";
        File f = new File(path);
        //没网的时候去内存找图片，内存不存在去SD卡，然后网络加载
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                //配置线程优先级，图片加载为首
                .threadPriority(100)
                //使用多个线程加载图片
                .threadPoolSize(3)
                //指定要缓存多大尺寸的图片
                .memoryCacheExtraOptions(200, 200)
                .memoryCacheSize(2 * 1024 * 1024)
                //配置SD卡缓存路径
                .diskCache(new UnlimitedDiskCache(f))
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();

        ImageLoader.getInstance().init(configuration);


    }

    public static MyApp getInstance() {
        return mInstance;
    }

}
