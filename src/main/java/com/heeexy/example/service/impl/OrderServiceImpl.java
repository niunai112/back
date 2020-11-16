package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addTime(JSONObject requestJson) {

        orderDao.deleteAll();

        JSONArray sendTimes = requestJson.getJSONArray("sendTime");
        if(sendTimes.isEmpty())
            return CommonUtil.successJson();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < sendTimes.size(); i++) {
            stringBuffer.append(sendTimes.getString(i)).append(",");
        }
        String sendTime = stringBuffer.substring(0,stringBuffer.length()-1);
        requestJson.put("orderTime",sendTime);
        requestJson.put("deleteStatus",1);
        orderDao.addTime(requestJson);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject getTime() {
        JSONObject jsonObject = new JSONObject();
        List<Integer> list = new ArrayList<>();
        String sendTime = orderDao.getTime();
        if(!StringTools.isNullOrEmpty(sendTime)){
            for (String str : sendTime.split(",")) {
                list.add(Integer.parseInt(str));
            }
        }
        jsonObject.put("sendTime",list);
        return CommonUtil.successJson(jsonObject);
    }

    @Override
    public JSONObject checkTime(JSONObject jsonObject) {
        String[] sendTimes = orderDao.getTime().split(",");
        Date date = new Date();
        if(!StringTools.isNullOrEmpty(jsonObject.get("orderTime"))){
            date = jsonObject.getDate("orderTime");
        }
        JSONObject resultJson = new JSONObject();
        resultJson.put("result",getTimeResult(date,sendTimes));
        return CommonUtil.successJson(resultJson);
    }

    /**
     * 配送时间范围的判断
     *
     * @param date
     * @param strings
     * @return
     */
    private boolean getTimeResult(Date date, String[] strings) {
        boolean result = false;
        int[][] arrs = {{0, 1}, {2, 3}, {4, 5}, {6, 7},
                {8, 9}, {10, 11}, {12, 13}, {14, 15},
                {16, 17}, {18, 19}, {20, 21}, {22, 23},
                {24, 25}, {26, 27}, {28, 29}, {30, 31},
                {32, 33}, {34, 35}, {36, 37}, {38, 39},
                {40, 41}, {42, 43}, {44, 45}, {46, 47}};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int[] arr = arrs[hour];
        int number;
        if (min > 30) {
            number = arr[1];
        } else {
            number = arr[0];
        }
        for (String string : strings) {
            int num = Integer.parseInt(string);
            if (number == num) {
                result = true;
                break;
            }
        }
        return result;
    }

}

























