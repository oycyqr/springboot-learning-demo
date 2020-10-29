package com.oycbest.springbootzookeeper.controller;

import com.oycbest.springbootzookeeper.util.WatcherApi;
import com.oycbest.springbootzookeeper.util.ZkApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/10/29 9:25 下午
 */
@RestController
@RequestMapping("zk")
public class ZookeeperController {

    @Autowired
    private ZkApi zkApi;

    @GetMapping
    public Object zk(){
        zkApi.exists("/t1",null);
        return zkApi.getData("/t1", new WatcherApi());
    }
}
