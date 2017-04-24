package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIResult;
import com.taotao.common.IDUtils;
import com.taotao.common.TaotaoResult;
import com.taotao.mapper.ItemDescMapper;
import com.taotao.mapper.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemDesc;
import com.taotao.service.ItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Autowired
	private SolrServer solrServer;

	@Override
	public EasyUIResult getItemList(Integer page, Integer rows) {
		//设置分页
		PageHelper.startPage(page, rows);
		List<Item> list = itemMapper.getAll();
		//取分页信息
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIResult result = new EasyUIResult(total, list);
		return result;
	}
	
	
	@Override
	public void saveItem(Item item, String desc, String itemParams) {
		Date date = new Date();
		//获得商品id
		long id = IDUtils.genItemId();
		//添加商品信息
		item.setId(id);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		//添加商品描述
		//创建TbItemDesc对象
		ItemDesc itemDesc = new ItemDesc();
		//获得一个商品id
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//插入数据
		itemDescMapper.insert(itemDesc);
		
	}
	
	
	@Override
	public void updateItem(Item item, String desc, String itemParams) {
		Date date = new Date();
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.updateByPrimaryKey(item);
		//添加商品描述
		//创建TbItemDesc对象
		ItemDesc itemDesc = new ItemDesc();
		//获得一个商品id
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//插入数据
		itemDescMapper.updateByPrimaryKey(itemDesc);
		
	}

	@Override
	public TaotaoResult solrImportData() {
		List<Item> list = itemMapper.getAll();
		try{
			for (Item item : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", item.getId());
				document.addField("item_title", item.getTitle());
				document.addField("item_sell_point", item.getSellPoint());
				document.addField("item_price", item.getPrice());
				document.addField("item_image", item.getImage());
				//将文档写入索引库
				solrServer.add(document);
			}
			//提交修改
			solrServer.commit();

		}catch (Exception e){
			return TaotaoResult.build(500,e.toString());
		}
		return TaotaoResult.ok();
	}
}
