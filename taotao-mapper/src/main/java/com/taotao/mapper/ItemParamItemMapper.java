package com.taotao.mapper;

import com.taotao.pojo.ItemParamItem;

public interface ItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemParamItem record);

    int insertSelective(ItemParamItem record);

    ItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(ItemParamItem record);

    int updateByPrimaryKey(ItemParamItem record);
}