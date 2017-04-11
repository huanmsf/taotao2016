package com.taotao.service.impl;

import com.taotao.mapper.ItemCatMapper;
import com.taotao.pojo.ItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	@Override
	public List<ItemCat> getItemCatList(Long parentId) {
		//返回子节点列表
		List<ItemCat> list = itemCatMapper.getByParentId(parentId);
		return list;
	}



}
