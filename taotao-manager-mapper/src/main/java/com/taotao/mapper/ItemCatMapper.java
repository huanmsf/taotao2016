package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.ItemCat;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    ItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);

	List<ItemCat> getByParentId(Long parentId);
}