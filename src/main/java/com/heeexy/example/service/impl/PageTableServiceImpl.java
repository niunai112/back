package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.PageTableDao;
import com.heeexy.example.service.PageTableService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PageTableServiceImpl implements PageTableService {

    @Autowired
    private PageTableDao pageTableDao;

    @Override
    public JSONObject listPageTable(JSONObject request2Json) {
        //封装分页数据
        CommonUtil.fillPageParam(request2Json);
        //统计当前条件下查询数据总个数
        int count = pageTableDao.countListPageTable(request2Json);
        //获取当前条件下所有数据
        List<JSONObject> list = pageTableDao.listPageTable(request2Json);
        return CommonUtil.successPage(request2Json, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deletePageTable(JSONObject jsonObject) {
        pageTableDao.deletePageTable(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addPageTable(JSONObject jsonObject) {

        int maxId = pageTableDao.getMaxId();
        int newId = (maxId/100+1)*100;
        JSONObject listJson = new JSONObject();
        listJson.put("id",newId+1);
        listJson.put("menuCode",jsonObject.get("menuCode"));
        listJson.put("menuName",jsonObject.get("menuName"));
        listJson.put("permissionCode",jsonObject.getString("menuCode")+":list");
        listJson.put("permissionName","列表");
        listJson.put("requiredPermission",1);
        pageTableDao.addPageTable(listJson);

        JSONObject addJson = new JSONObject();
        addJson.put("id",newId+2);
        addJson.put("menuCode",jsonObject.get("menuCode"));
        addJson.put("menuName",jsonObject.get("menuName"));
        addJson.put("permissionCode",jsonObject.getString("menuCode")+":add");
        addJson.put("permissionName","新增");
        addJson.put("requiredPermission",2);
        pageTableDao.addPageTable(addJson);

        JSONObject updateJson = new JSONObject();
        updateJson.put("id",newId+3);
        updateJson.put("menuCode",jsonObject.get("menuCode"));
        updateJson.put("menuName",jsonObject.get("menuName"));
        updateJson.put("permissionCode",jsonObject.getString("menuCode")+":update");
        updateJson.put("permissionName","修改");
        updateJson.put("requiredPermission",2);
        pageTableDao.addPageTable(updateJson);

        return CommonUtil.successJson();
    }
}
