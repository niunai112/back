package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.PageTableService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pageTable")
public class PageTableController {

    @Autowired
    private PageTableService pageTableService;

    @GetMapping("/listPageTable")
    public JSONObject listPageTable(HttpServletRequest request){
        JSONObject jsonObject = CommonUtil.request2Json(request);
        return pageTableService.listPageTable(jsonObject);
    }

    @PostMapping("/addPageTable")
    public JSONObject addPageTable(@RequestBody JSONObject jsonObject){
        return pageTableService.addPageTable(jsonObject);
    }

    @PostMapping("/deletePageTable")
    public JSONObject deletePageTable(@RequestBody JSONObject jsonObject){
        return pageTableService.deletePageTable(jsonObject);
    }

}
