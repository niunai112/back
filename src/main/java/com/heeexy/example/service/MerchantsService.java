package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface MerchantsService {
    JSONObject selectMerchants(JSONObject jsonObject);

    JSONObject selectOne();

    JSONObject addMerchants(JSONObject jsonObject);

    JSONObject updateMerchants(JSONObject jsonObject);
}
