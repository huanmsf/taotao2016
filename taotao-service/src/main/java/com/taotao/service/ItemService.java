package com.taotao.service;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Item;

/**
 * 查找SERVICE 由rest调用
 */
public interface ItemService {
	public EasyUIResult getItemList(Integer page, Integer rows);

	public void saveItem(Item item, String desc, String itemParams);
	
	public void updateItem(Item item, String desc, String itemParams);

	public TaotaoResult solrImportData();
}
