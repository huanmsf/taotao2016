package com.taotao.service;

import com.taotao.pojo.ItemCat;

import java.util.List;

public interface ItemCatService {
	public List<ItemCat> getItemCatList(Long parentId);

}

