package com.taotao.service.impl;
import com.taotao.common.HttpClientUtil;
import com.taotao.common.JsonUtils;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.ADItem;
import com.taotao.pojo.Content;
import com.taotao.service.AdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-4-12.
 */
@Service
public class ADServiceImpl implements AdService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${INDEX_AD1_URL}")
    private String INDEX_AD1_URL;

    @Override
    public String getAdItemList() {
        //调用服务层的服务查询打广告位的数据
        String result = HttpClientUtil.doGet(REST_BASE_URL + INDEX_AD1_URL);
        //把json数据转换成对象
        TaotaoResult taotaoResult = TaotaoResult.formatToList(result, Content.class);
        List<ADItem> itemList = new ArrayList<>();
        if (!StringUtils.isEmpty(taotaoResult)&&taotaoResult.getStatus() == 200 ) {
            List<Content> contentList = (List<Content>) taotaoResult.getData();
            for (Content tbContent : contentList) {
                ADItem item = new ADItem();
                item.setHeight(240);
                item.setWidth(670);
                item.setSrc(tbContent.getPic());
                item.setHeightB(240);
                item.setWidth(550);
                item.setSrcB(tbContent.getPic2());
                item.setAlt(tbContent.getTitleDesc());
                item.setHref(tbContent.getUrl());
                itemList.add(item);
            }

        }
        return JsonUtils.objectToJson(itemList);
    }
}
