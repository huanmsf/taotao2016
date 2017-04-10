package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.EasyUIResult;
import com.taotao.service.ItemParamService;

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

	
	
}