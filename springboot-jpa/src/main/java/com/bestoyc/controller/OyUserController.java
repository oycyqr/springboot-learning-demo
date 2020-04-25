package com.bestoyc.controller;

import com.bestoyc.dao.OyUserRepository;
import com.bestoyc.entity.OyUser;
import com.bestoyc.service.OyUserService;
import com.bestoyc.util.PinyinUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    /**
     * 依赖注入，注入用户JPA接口类
     */
    @Resource
    private OyUserRepository oyUserRepository;

    @Resource
    private EntityManager entityManager;

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
    @GetMapping
    public String index() {
        return "redirect:/user/list";
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
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("listByKeyWord")
    public String listByKeyWord(ModelMap model, OyUser user) {
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()
                //模糊查询匹配开头，即{username}% .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.contains())
                //全部模糊查询，即%{address}%
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("account", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("age", ExampleMatcher.GenericPropertyMatchers.contains())
                //忽略字段，即不管password是什么值都不加入查询条件
                //.withIgnorePaths("sex", "age")
                // 忽略属性：id。因为是基本类型，需要忽略掉
                .withIgnorePaths("id");
        //创建实例
        Example<OyUser> example = Example.of(user, matcher);
        //查询
        List<OyUser> userList = oyUserRepository.findAll(example);
        model.put("users", userList);
        return "user";
    }

    /**
     * 查询用户列表1
     *
     * @return 用户列表
     */
    @GetMapping("listByKeyWord1")
    public String listByKeyWord1(ModelMap model, OyUser user) {
        //创建CriteriaBuilder安全查询工厂
        //CriteriaBuilder是一个工厂对象,安全查询的开始.用于构建JPA安全查询.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //创建CriteriaQuery安全查询主语句
        //CriteriaQuery对象必须在实体类型或嵌入式类型上的Criteria 查询上起作用。
        CriteriaQuery<OyUser> query = criteriaBuilder.createQuery(OyUser.class);
        //Root 定义查询的From子句中能出现的类型
        Root<OyUser> userRoot = query.from(OyUser.class);
        //Predicate 过滤条件 构建where字句可能的各种条件
        //这里用List存放多种查询条件,实现动态查询
        List<Predicate> predicatesList = new ArrayList<>();
        //name模糊查询 ,like语句
        if (user.getName() != null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.like(
                                    userRoot.get("name"), "%" + user.getName() + "%")));
        }
        //account模糊查询 ,like语句
        if (user.getAccount() != null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.like(
                                    userRoot.get("account"), "%" + user.getAccount() + "%")));
        }
        // itemPrice 小于等于 <= 语句
        if (user.getAge() != null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.le(
                                    userRoot.get("age"), user.getAge())));
        }
        //itemStock 大于等于 >= 语句 criteriaBuilder.ge
        //where()拼接查询条件
        query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

        TypedQuery<OyUser> typedQuery = entityManager.createQuery(query);
        //查询
        List<OyUser> userList = typedQuery.getResultList();
        model.put("users", userList);
        return "user";
    }

/**
 * 查询用户列表2
 *
 * @return 用户列表
 */
@GetMapping("listByKeyWord2")
public String listByKeyWord2(ModelMap model, OyUser oyUser) {
    Specification querySpeci = new Specification() {
        @Override
        public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList();
            if (oyUser.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + oyUser.getName() + "%"));
            }
            if (oyUser.getAccount() != null) {
                predicates.add(criteriaBuilder.like(root.get("account"), "%" + oyUser.getAccount() + "%"));
            }
            if (null != oyUser.getAge()) {
                predicates.add(criteriaBuilder.gt(root.get("age"), oyUser.getAge()));
            }
            if (null != oyUser.getSex()) {
                predicates.add(criteriaBuilder.equal(root.get("sex"), oyUser.getSex()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }
    };
    Pageable pageable = PageRequest.of(0, 3);
    Page<OyUser> userListPage = oyUserRepository.findAll(querySpeci, pageable);
    model.put("users", userListPage.getContent());
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
    public HashMap<String, Object> test() {
        HashMap<String, Object> resultMap = new HashMap<>();
        //根据姓名查找
        resultMap.put("根据姓名查找:findByName[oyc]", oyUserRepository.findByName("oyc"));
        //根据姓名模糊查找
        resultMap.put("根据姓名模糊查找:findByNameLike[oyc]", oyUserRepository.findByNameLike("%oyc%"));
        //根据性别查找
        resultMap.put("根据性别查找:findBySex[male]", oyUserRepository.findBySex("male"));
        //根据年龄区间查找
        resultMap.put("根据年龄区间查找（小于12岁）:findByAgeLessThan[12]", oyUserRepository.findByAgeLessThan(12));
        resultMap.put("根据年龄区间查找:findByAgeBetween[1,18]", oyUserRepository.findByAgeBetween(1, 18));
        resultMap.put("根据年龄区间排序查找:findByAgeBetweenOrderByAge[1,18]", oyUserRepository.findByAgeBetweenOrderByAge(1, 18));

        resultMap.put("根据创建时间排序查找:findOrderByCreateTime", oyUserRepository.findByNameLikeOrderByCreateTime("%%"));

        //分页查找
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 3, sort);
        resultMap.put("分页查找(1,5):findAll-sort", oyUserRepository.findAll(sort));
        resultMap.put("分页查找(1,5):findAll-page-sort", oyUserRepository.findAll(pageable));

        //设置账号
        List<OyUser> userList = oyUserRepository.findAll();
        for (OyUser user : userList) {
            user.setAccount(PinyinUtil.getPinyin(user.getName()).split(",")[0]);
        }
        oyUserRepository.saveAll(userList);
        return resultMap;
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("findByName")
    @ResponseBody
    public ResponseEntity findByName(OyUser user) {
        List<OyUser> userList = oyUserRepository.findByName(user.getName());
        return ResponseEntity.ok().body(userList);
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("findBySex")
    @ResponseBody
    public ResponseEntity findBySex(OyUser user) {
        List<OyUser> userList = oyUserRepository.findBySex(user.getSex());
        return ResponseEntity.ok().body(userList);
    }

    /**
     * 新增用户
     */
    @PostMapping
    public String addUser(OyUser user) {
        if (user.getId() != null) {
            user.setCreateTime(new Date());
        }
        return "redirect:/user/list";
    }

    /**
     * 修改用户
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity updateUser(OyUser user) {
        OyUser oyUser = oyUserService.updateUser(user);
        return ResponseEntity.ok().body(oyUser);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("{userId}")
    @ResponseBody
    public ResponseEntity delUser(@PathVariable("userId") Integer userId) {
        oyUserService.delUser(userId);
        return ResponseEntity.ok().body(true);
    }
}
