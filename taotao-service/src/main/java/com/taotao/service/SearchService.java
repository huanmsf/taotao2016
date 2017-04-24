package com.taotao.service;

/**
 * Created by root on 17-4-22.
 */

import com.taotao.pojo.SearchResult;

/**
 * 查找SERVICE 由portal调用
 * 相当于前台处理查询的工具
 */
public interface SearchService {
    public SearchResult searchItemList(String queryString, Integer page) throws Exception;
}
