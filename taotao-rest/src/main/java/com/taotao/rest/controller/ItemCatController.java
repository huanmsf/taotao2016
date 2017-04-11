package com.taotao.rest.controller;

import com.taotao.common.JsonUtils;
import com.taotao.rest.pojo.ItemCatRestResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by root on 17-4-11.
 */
@Controller
@RequestMapping(value="/itemcat")
public class ItemCatController {

    @Autowired
    ItemCatService itemCatService;

    @RequestMapping(value="/all", produces= MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String queryAll(String callback) throws Exception {
        //查询分类列表
        ItemCatRestResult itemCatRestResult = itemCatService.queryAllCategory();
        //把对象转换成json数据
        String jsonResult = JsonUtils.objectToJson(itemCatRestResult);
        //拼接字符串
        String resultStr = callback + "(" + jsonResult + ");";

        return resultStr;
    }

}
