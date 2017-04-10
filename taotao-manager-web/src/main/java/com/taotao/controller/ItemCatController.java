package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.ItemCat;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	@ResponseBody
	//如果id为null是使用默认值，也就是parentid为0的分类列表
	public List categoryList(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception {
		List catList = new ArrayList();
		//查询数据库
		List<ItemCat> list = itemCatService.getItemCatList(parentId);
		for (ItemCat tbItemCat : list) {
			Map node = new HashMap<>();
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", tbItemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
	
}