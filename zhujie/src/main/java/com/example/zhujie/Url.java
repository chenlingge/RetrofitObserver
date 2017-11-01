package com.example.zhujie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 陈令鸽 on 2017/10/31.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {
    String value();
}
