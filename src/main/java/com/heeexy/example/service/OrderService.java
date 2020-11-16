package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface OrderService {

    JSONObject addTime(JSONObject requestJson);

    JSONObject getTime();

    JSONObject checkTime(JSONObject jsonObject);
}
