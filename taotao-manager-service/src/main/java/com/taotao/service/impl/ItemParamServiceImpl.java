package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIResult;
import com.taotao.mapper.ItemParamMapper;
import com.taotao.pojo.ItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	ItemParamMapper itemParamMapper;

	@Override
	public EasyUIResult getItemParamList(Integer page, Integer rows) {

		// 设置分页
		PageHelper.startPage(page, rows);
		List<ItemParam> list = itemParamMapper.getAll();
		// 取分页信息
		PageInfo<ItemParam> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIResult result = new EasyUIResult(total, list);
		return result;
	}

	@Override
	public void saveItemParam(ItemParam itemParam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItemParam(ItemParam itemParam) {
		// TODO Auto-generated method stub

	}

}
