package com.taotao.service;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.ItemParam;

public interface ItemParamService {
	public EasyUIResult getItemParamList(Integer page, Integer rows);

	public void saveItemParam(ItemParam itemParam);
	
	public void updateItemParam(ItemParam itemParam);

	public TaotaoResult queryCatalogById(long cid);
}
