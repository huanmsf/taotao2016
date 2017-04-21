package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.Item;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/list")
	//设置相应的内容为json数据
	@ResponseBody
	public EasyUIResult getItemlist(@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="30")Integer rows) throws Exception {
		//查询商品列表
		EasyUIResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
		public TaotaoResult saveItem(Item item, String desc) throws Exception {
			//添加商品信息
			itemService.saveItem(item, desc, null);
			return TaotaoResult.ok();
		}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateItem(Item item, String desc) throws Exception {
		//添加商品信息
		itemService.updateItem(item, desc, null);
		return TaotaoResult.ok();
	}
	
	
	
}