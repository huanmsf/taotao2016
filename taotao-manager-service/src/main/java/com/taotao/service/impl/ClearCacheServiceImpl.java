package com.taotao.service.impl;

import com.taotao.common.TaotaoResult;
import com.taotao.service.ClearCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * Created by root on 17-4-21.
 */
@Service
public class ClearCacheServiceImpl implements ClearCacheService {

    @Autowired
    private JedisCluster cluster;
    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY;

    @Override
    public TaotaoResult clearContentCache(Long cid)  {
        //删除cid对应的内容
        cluster.hdel(CONTENT_KEY, cid.toString());
        return TaotaoResult.ok();
    }
}
