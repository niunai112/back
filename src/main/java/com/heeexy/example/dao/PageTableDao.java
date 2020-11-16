package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface PageTableDao {
    int countListPageTable(JSONObject request2Json);

    List<JSONObject> listPageTable(JSONObject request2Json);

    void deletePageTable(JSONObject jsonObject);

    void addPageTable(JSONObject jsonObject);

    int getMaxId();
}
