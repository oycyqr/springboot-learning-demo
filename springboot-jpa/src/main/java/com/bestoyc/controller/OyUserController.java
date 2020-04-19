package com.bestoyc.controller;

import com.bestoyc.entity.OyUser;
import com.bestoyc.service.OyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Title:
 * @Description:用户控制类
 * @date 2018/7/1615:10
 */
@Controller
@RequestMapping("/user")
public class OyUserController {
    /**
     * 依赖注入，注入用户服务类
     */
    @Resource
    private OyUserService oyUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ResponseBody
    public OyUser selectOne(@PathVariable("id") Integer id) {
        return oyUserService.getUserById(id);
    }

    /**
     * 查询用户列表
     * @return 用户列表
     */
    @GetMapping("list")
    public String list(ModelMap model){
        List<OyUser> users = oyUserService.getUserList();
        model.addAttribute("users",users);
        return "user";
    }

    /**
     * 新增用户
     */
    @PostMapping
    @ResponseBody
    public OyUser addUser(OyUser user){
        return oyUserService.addUser(user);
    }

    /**
     * 修改用户
     */
    @PutMapping
    @ResponseBody
    public OyUser updateUser(OyUser user){
        return oyUserService.updateUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("{userId}")
    @ResponseBody
    public void delUser(@PathVariable("userId") Integer userId){
        oyUserService.delUser(userId);
    }
}
