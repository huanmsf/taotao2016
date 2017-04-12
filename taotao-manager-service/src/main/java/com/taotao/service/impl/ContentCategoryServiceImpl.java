package com.taotao.service.impl;

import com.taotao.common.TaotaoResult;
import com.taotao.mapper.ContentCategoryMapper;
import com.taotao.pojo.ContentCategory;
import com.taotao.pojo.EasyUITreeNode;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 17-4-12.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentid)  {

        List<ContentCategory> list=contentCategoryMapper.getContentCategoryListByPid( parentid);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (ContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            //判断是否是父节点
            if (tbContentCategory.getIsParent()) {
                node.setState("closed");
            } else {
                node.setState("open");
            }
            resultList.add(node);
        }
        return resultList;
    }



    @Override
    public TaotaoResult addNode(long parentid, String name)  {
        Date date = new Date();
        //添加一个新节点
        //创建一个节点对象
        ContentCategory node = new ContentCategory();
        node.setName(name);
        node.setParentId(parentid);
        node.setIsParent(false);
        node.setCreated(date);
        node.setUpdated(date);
        node.setSortOrder(1);
        //状态。可选值:1(正常),2(删除)
        node.setStatus(1);
        //插入新节点。需要返回主键
        contentCategoryMapper.insert(node);
        //判断如果父节点的isparent不是true修改为true
        //取父节点的内容
        ContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentid);
        if (!parentNode.getIsParent()) {
            parentNode.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parentNode);
        }
        //把新节点返回
        return TaotaoResult.ok(node);
    }
}
