package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.MerchantsService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    @Autowired
    private MerchantsService merchantsService;

    @GetMapping("/listMerchants")
    public JSONObject listMerchants(HttpServletRequest request){
        JSONObject jsonObject=CommonUtil.request2Json(request);
        return merchantsService.selectMerchants(jsonObject);
    }

    @PostMapping("/addMerchants")
    public JSONObject addMerchants(@RequestBody JSONObject jsonObject){
        return merchantsService.addMerchants(jsonObject);
    }

    @PostMapping("/updateMerchants")
    public JSONObject updateMerchants(@RequestBody JSONObject jsonObject){
        return merchantsService.updateMerchants(jsonObject);
    }

    @GetMapping("/selectOne")
    public JSONObject selectOne(){
        return merchantsService.selectOne();
    }
}
