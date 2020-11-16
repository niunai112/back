package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface PageTableService {
    JSONObject listPageTable(JSONObject request2Json);

    JSONObject deletePageTable(JSONObject jsonObject);

    JSONObject addPageTable(JSONObject jsonObject);
}
