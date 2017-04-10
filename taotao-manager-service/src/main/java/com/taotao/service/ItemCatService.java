package com.taotao.service;

import java.util.List;

import com.taotao.pojo.ItemCat;

public interface ItemCatService {
	public List<ItemCat> getItemCatList(Long parentId);
}
