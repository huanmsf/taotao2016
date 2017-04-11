package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
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

	/**
	 * 根据类别查询规格参数
	 * @param cid
	 * @return
	 */

	@Override
	public TaotaoResult queryCatalogById(long cid) {

		List<ItemParam> list = itemParamMapper.getItemParamByCid(cid);
		//如果查询中有结果返回查询结果
		if (list != null && !list.isEmpty()) {
			return TaotaoResult.ok(list.get(0));
		}
		//查询成功但是没有查到数据
		return TaotaoResult.ok();
	}

}
