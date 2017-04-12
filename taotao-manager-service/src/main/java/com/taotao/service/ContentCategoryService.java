package com.taotao.service;

import com.taotao.common.TaotaoResult;
import com.taotao.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by root on 17-4-12.
 */
public interface ContentCategoryService {
    public List<EasyUITreeNode> getContentCategoryList(long parentid);
    public TaotaoResult addNode(long parentid, String name);
}
