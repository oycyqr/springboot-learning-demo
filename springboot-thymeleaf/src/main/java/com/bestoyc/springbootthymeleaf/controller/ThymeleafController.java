package com.bestoyc.springbootthymeleaf.controller;

import com.bestoyc.springbootthymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/20 9:02 下午
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @GetMapping("test")
    public String test(Model model) {
        model.addAttribute("title", "Welcome To My blog");
        List<String> lists = new ArrayList<>();
        lists.add("列表1");
        lists.add("列表2");
        lists.add("列表3");
        lists.add("列表4");
        model.addAttribute("lists", lists);

        User ouyangcheng = new User(1, "ouyangcheng");
        model.addAttribute("user", ouyangcheng);
        return "thymeleaf";
    }
}
