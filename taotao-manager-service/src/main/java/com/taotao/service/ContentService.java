package com.taotao.service;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Content;

/**
 * Created by root on 17-4-12.
 */
public interface ContentService {
    public EasyUIResult getContentList(long catId, Integer page, Integer rows);
    public TaotaoResult addContent(Content content);
}
