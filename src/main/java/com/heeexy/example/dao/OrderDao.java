package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

public interface OrderDao {
    void addTime(JSONObject requestJson);

    String getTime();

    void deleteAll();
}
