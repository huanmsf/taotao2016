package com.taotao.rest.controller;

import com.taotao.common.ExceptionUtil;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.SearchResult;
import com.taotao.service.ItemSearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by root on 17-4-22.
 */

@Controller
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;

    @RequestMapping("/q")
    @ResponseBody
    public TaotaoResult search(@RequestParam(value = "kw") String queryString,
                               @RequestParam(value = "page", defaultValue = "1") Integer page) {

        if (StringUtils.isBlank(queryString)) {
            return TaotaoResult.build(400, "查询条件是必须的参数");
        }
        SearchResult result = null;
        try {
            result = itemSearchService.searchItem(queryString, page);

        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }

        return TaotaoResult.ok(result);
    }
}
