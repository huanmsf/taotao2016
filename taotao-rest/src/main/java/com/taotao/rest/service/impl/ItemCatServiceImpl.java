package com.taotao.rest.service.impl;

import com.taotao.mapper.ItemCatMapper;
import com.taotao.pojo.ItemCat;
import com.taotao.rest.pojo.ItemCatRest;
import com.taotao.rest.pojo.ItemCatRestResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-4-11.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCatRestResult queryAllCategory() {

        ItemCatRestResult result = new ItemCatRestResult();
        result.setData(getItemCatList(0l));

        return result;
    }

    /**
     * 查询分类列表
     * <p>Title: getItemCatList</p>
     * <p>Description: </p>
     * @param parentid
     * @return
     */
    private List<?> getItemCatList(long parentid) {

        List<ItemCat> list = itemCatMapper.getByParentId(parentid);
        List dataList = new ArrayList();
        for (ItemCat tbItemCat : list) {
            //判断是否为父节点
            if (tbItemCat.getIsParent()) {
                ItemCatRest itemCatRest = new ItemCatRest();
                itemCatRest.setUrl("/category/" + tbItemCat.getId() + ".html");
                itemCatRest.setName(tbItemCat.getName());
                //递归调用
                itemCatRest.setItem(getItemCatList(tbItemCat.getId()));
                //添加到列表
                dataList.add(itemCatRest);
            } else {
                String catItem = "/item/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
                dataList.add(catItem);
            }
        }
        return dataList;
    }
}
