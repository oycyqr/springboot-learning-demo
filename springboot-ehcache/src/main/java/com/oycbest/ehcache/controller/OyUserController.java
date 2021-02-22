package com.oycbest.ehcache.controller;

import com.oycbest.ehcache.entity.OyUser;
import com.oycbest.ehcache.service.OyUserService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Description: 用户控制类
 * @date 2018/7/1615:10
 */
@RestController
@RequestMapping("/user")
public class OyUserController {
    /**
     * 依赖注入，注入用户服务类
     */
    @Resource
    private OyUserService oyUserService;

    @Resource
    CacheManager cacheManager;

    @GetMapping("cacheTest/{userId}")
    public OyUser cacheTest(@PathVariable Integer userId) {
        //获取所有cache 配置
        Iterable<String> cacheNames = cacheManager.getCacheNames();
        cacheNames.forEach(name -> System.out.println("name = " + name));

        //获取缓存对象，"user_cache" 就是 ehcache.xml 中 <cache> 标签的 alias
        Cache cache = cacheManager.getCache("user_cache");
        Cache.ValueWrapper valueWrapper = cache.get("userId-" + userId);
        if (valueWrapper != null && valueWrapper instanceof OyUser) {
            return (OyUser) valueWrapper.get();
        }
        //创建一个对象
        OyUser user = oyUserService.getUserById(userId);
        System.out.println(user.toString());

        //存入缓存
        cache.put("userId-" + userId, user);

        //获取刚刚存入的值
        valueWrapper = cache.get("userId-" + userId);
        if (null != valueWrapper) {
            //这里获取  ehcache.xml 中 <cache>  value-type 定义的类型，可以直接强转。
            OyUser obj = (OyUser) valueWrapper.get();
            //输出
            System.out.println(obj.toString());
        }
        return user;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Cacheable(cacheNames = "user_cache", key = "'userId'+#id")// 从缓存获取，key为ID，缓存具体看 ehcache.xml 配置文件
    public OyUser selectOne(@PathVariable("id") Integer id) {
        // 从数据库查询并记录到缓存
        OyUser user = oyUserService.getUserById(id);
        return user;
    }


    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("list")
    public List<OyUser> list() {
        // 从数据库查询并记录到缓存
        return oyUserService.getUserList();
    }

    /**
     * 新增用户
     */
    @PostMapping
    public OyUser addUser(OyUser user) {
        return oyUserService.addUser(user);
    }

    /**
     * 修改用户
     */
    @PutMapping
    public OyUser updateUser(OyUser user) {
        return oyUserService.updateUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("{userId}")
    public void delUser(@PathVariable("userId") Integer userId) {
        oyUserService.delUser(userId);
    }
}
