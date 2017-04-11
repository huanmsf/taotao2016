package com.taotao.mapper;

import com.taotao.pojo.ItemParam;

import java.util.List;

public interface ItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemParam record);

    int insertSelective(ItemParam record);

    ItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemParam record);

    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    int updateByPrimaryKey(ItemParam record);
    
    List<ItemParam> getAll();

    List<ItemParam> getItemParamByCid(Long cid);
}