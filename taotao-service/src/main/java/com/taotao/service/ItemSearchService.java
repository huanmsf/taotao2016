package com.taotao.service;

import com.taotao.pojo.SearchResult;

/**
 * Created by root on 17-4-22.
 */
public interface ItemSearchService {
    public SearchResult searchItem(String queryString, Integer page)throws Exception;
}
