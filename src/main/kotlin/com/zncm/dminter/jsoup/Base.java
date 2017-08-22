package com.zncm.dminter.jsoup;

import com.alibaba.fastjson.JSON;

/**
 * Created by jiaomx on 2017/7/20.
 */

public class Base {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
