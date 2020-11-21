package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.MerchantsDao;
import com.heeexy.example.service.MerchantsService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MerchantsServiceImpl implements MerchantsService {
    @Autowired
    private MerchantsDao merchantsDao;

    @Override
    public JSONObject selectMerchants(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list=merchantsDao.selectMerchants(jsonObject);
        int conut=merchantsDao.selectConut(jsonObject);
        return CommonUtil.successPage(jsonObject,list,conut);
    }

    @Override
    public JSONObject selectOne() {
        Session session= SecurityUtils.getSubject().getSession();
        JSONObject userInfo=(JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
        int userId=userInfo.getInteger("userId");
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("userId",userId);
        JSONObject jsonObject=merchantsDao.selectOne(jsonObject1);
        return CommonUtil.successJson(jsonObject);
    }

    @Override
    public JSONObject addMerchants(JSONObject jsonObject) {
        merchantsDao.addMerchants(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject updateMerchants(JSONObject jsonObject) {
        Session session= SecurityUtils.getSubject().getSession();
        JSONObject userInfo=(JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
        int userId=userInfo.getInteger("userId");
        jsonObject.put("userId",userId);
        merchantsDao.updateMerchants(jsonObject);
        return CommonUtil.successJson();
    }
}
