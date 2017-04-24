package com.taotao.service.impl;

import com.taotao.common.HttpClientUtil;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.SearchResult;
import com.taotao.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 17-4-22.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;
    @Override
    public SearchResult searchItemList(String queryString, Integer page) throws Exception {
        //查询参数
        Map<String, String> param = new HashMap<>();
        param.put("kw", queryString);
        param.put("page", page==null?"1":page.toString());
        //调用taotao-search提供的搜索服务
        String resultString = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
        //转换成taotaoResult对象
        TaotaoResult taotaoResult = TaotaoResult.formatToPojo(resultString, SearchResult.class);
        SearchResult searchResult = null;
        //查询成功
        if (taotaoResult.getStatus() == 200) {
            //取查询结果
            searchResult = (SearchResult) taotaoResult.getData();
        }

        return searchResult;
    }
}
