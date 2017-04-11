package com.taotao.controller;

import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item/param/")
public class ItemParamController {
	@Autowired
	ItemParamService itemParamService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIResult getItemParam(@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="10")Integer rows){
		
		return itemParamService.getItemParamList(page, rows);
	}

	@RequestMapping("query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult queryCatalogById(@PathVariable long cid) throws Exception {
		//根据分类id查询列表
		TaotaoResult result = itemParamService.queryCatalogById(cid);
		return result;
	}
	
}