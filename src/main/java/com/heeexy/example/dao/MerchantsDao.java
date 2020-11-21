package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface MerchantsDao {
    List<JSONObject> selectMerchants(JSONObject jsonObject);

    JSONObject selectOne(JSONObject jsonObject);

    int selectConut(JSONObject jsonObject);

    int addMerchants(JSONObject jsonObject);

    int updateMerchants(JSONObject jsonObject);
}
