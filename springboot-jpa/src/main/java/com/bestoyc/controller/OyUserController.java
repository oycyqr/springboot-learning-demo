package com.bestoyc.controller;

import com.bestoyc.dao.OyUserCrudRepository;
import com.bestoyc.dao.OyUserRepository;
import com.bestoyc.entity.OyUser;
import com.bestoyc.service.OyUserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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

    @Resource
    private OyUserCrudRepository crudRepository;


    /**
     * 依赖注入，注入用户JPA接口类
     */
    @Resource
    private OyUserRepository oyUserRepository;

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
     *
     * @return 用户列表
     */
    @GetMapping("list")
    public String list(ModelMap model) {
        List<OyUser> users = oyUserService.getUserList();
        model.addAttribute("users", users);
        return "user";
    }

    /**
     * 编辑用户
     *
     * @return 用户编辑页面
     */
    @GetMapping("/manage/{page}")
    public String page(@PathVariable("page") String page, ModelMap model, HttpServletRequest request) {
        String id = request.getParameter("id");
        if (!StringUtils.isNullOrEmpty(id)) {
            OyUser user = oyUserRepository.getOne(Integer.valueOf(id));
            model.addAttribute("user", user);
        }
        return page;
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("test")
    @ResponseBody
    public HashMap<String, Object> list1() {
        HashMap<String, Object> resultMap = new HashMap<>();
        //根据姓名查找
        resultMap.put("根据姓名查找:findByName[oyc]", crudRepository.findByName("oyc"));
        //根据姓名模糊查找
        resultMap.put("根据姓名模糊查找:findByNameLike[oyc]", crudRepository.findByNameLike("%oyc%"));
        //根据性别查找
        resultMap.put("根据性别查找:findBySex[male]", crudRepository.findBySex("male"));
        //根据年龄区间查找
        resultMap.put("根据年龄区间查找（小于12岁）:findByAgeLessThan[12]", crudRepository.findByAgeLessThan(12));
        resultMap.put("根据年龄区间查找:findByAgeBetween[1,18]", crudRepository.findByAgeBetween(1, 18));
        resultMap.put("根据年龄区间排序查找:findByAgeBetweenOrderByAge[1,18]", crudRepository.findByAgeBetweenOrderByAge(1, 18));

        resultMap.put("根据创建时间排序查找:findOrderByCreateTime", crudRepository.findByNameLikeOrderByCreateTime("%%"));

        //分页查找
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 3, sort);
        resultMap.put("分页查找(1,5):findAll-sort", oyUserRepository.findAll(sort));
        resultMap.put("分页查找(1,5):findAll-page-sort", oyUserRepository.findAll(pageable));
        return resultMap;
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("findByName")
    @ResponseBody
    public List<OyUser> findByName(OyUser user) {
        return crudRepository.findByName(user.getName());
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("findBySex")
    @ResponseBody
    public List<OyUser> findBySex(OyUser user) {
        return crudRepository.findBySex(user.getSex());
    }

    /**
     * 新增用户
     */
    @PostMapping
    @ResponseBody
    public OyUser addUser(OyUser user) {
        if (user.getId() != null) {
            user.setCreateTime(new Date());
        }
        return oyUserService.addUser(user);
    }

    /**
     * 修改用户
     */
    @PutMapping
    @ResponseBody
    public OyUser updateUser(OyUser user) {
        return oyUserService.updateUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("{userId}")
    @ResponseBody
    public void delUser(@PathVariable("userId") Integer userId) {
        oyUserService.delUser(userId);
    }
}
