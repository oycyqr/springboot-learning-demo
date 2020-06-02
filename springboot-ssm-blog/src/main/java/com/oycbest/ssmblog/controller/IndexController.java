package com.oycbest.ssmblog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index控制层
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Controller
@RequestMapping("index")
public class IndexController {

    /**
     * 主页
     */
    @GetMapping
    public String index() {
        return "/admin/index";
    }

    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public String page(Page page) {
        return "/admin/list";
    }

    /**
     * 详情页面
     *
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return "/admin/detail";
    }

}
