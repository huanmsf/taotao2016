package com.taotao.controller;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Content;
import com.taotao.service.ClearCacheService;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by root on 17-4-12.
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    ClearCacheService clearCacheService;
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIResult getContentList(Long categoryId, Integer page, Integer rows) throws Exception {
        EasyUIResult result = contentService.getContentList(categoryId, page, rows);

        return result;

    }


    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addContent(Content content) throws Exception {
        TaotaoResult result = contentService.addContent(content);
        clearCacheService.clearContentCache(content.getCategoryId());
        return result;
    }
}