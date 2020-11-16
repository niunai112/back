package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkTime")
    public JSONObject checkTime(@RequestBody JSONObject jsonObject){
        return orderService.checkTime(jsonObject);
    }

    @PostMapping("/addTime")
    public JSONObject addTime(@RequestBody JSONObject jsonObject){
        return orderService.addTime(jsonObject);
    }

    @GetMapping("/getTime")
    public JSONObject getTime(){
        return orderService.getTime();
    }

}
