package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIResult;
import com.taotao.common.TaotaoResult;
import com.taotao.mapper.ContentMapper;
import com.taotao.pojo.Content;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by root on 17-4-12.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public EasyUIResult getContentList(long catId, Integer page, Integer rows) {

        //分页处理
        PageHelper.startPage(page, rows);
        List<Content> list = contentMapper.selectByCatid(catId);
        //取分页信息
        PageInfo<Content> pageInfo = new PageInfo<>(list);
        EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), list);
        return result;
    }


    @Override
    public TaotaoResult addContent(Content content)  {

        //把图片信息保存至数据库
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //把内容信息添加到数据库
        contentMapper.insert(content);

        return TaotaoResult.ok();
    }


    @Override
    public TaotaoResult getContentList(long cid)  {

        List<Content> list = contentMapper.selectByCatid(cid);
        return TaotaoResult.ok(list);
    }


/*    @Override
    public TaotaoResult getContentList(long cid) {
        //缓存逻辑，先判断缓存中是否有内容
        try {
            String contentStr = cluster.hget(TB_CONTENT_KEY, cid + "");
            if (!StringUtils.isBlank(contentStr)) {
                //把json字符串转换成对象列表
                List<Content> list = JsonUtils.jsonToList(contentStr, TbContent.class);
                //返回结果
                return TaotaoResult.ok(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //缓存不能影响正常逻辑
        }
        //从数据库中加载数据
        List<Content> list = contentMapper.selectByCatid(cid);
        //把结果添加到redis数据库中
        try {
            cluster.hset(TB_CONTENT_KEY, cid + "", JsonUtils.objectToJson(list));
        } catch (Exception e) {
            e.printStackTrace();
            //缓存不能影响正常逻辑
        }

        //返回结果
        return TaotaoResult.ok(list);
    }*/

}
