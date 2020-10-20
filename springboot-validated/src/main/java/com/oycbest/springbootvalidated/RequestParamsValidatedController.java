package com.oycbest.springbootvalidated;

import com.oycbest.springbootvalidated.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 参数校验测试 控制类
 * @author Administrator
 */
@RestController
@RequestMapping("request")
@Validated
public class RequestParamsValidatedController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public User test(@NotNull(message = "name 不能为空") String name,
                     @NotNull(message = "年龄 不能为空")  @Max(value = 99, message = "不能大于99岁") Integer age) {
        logger.info("name:" + name + " -age:" + age);
        return new User(name, age);
    }

    @PostMapping
    public User save(@Validated User user) {
        logger.info(user.toString());
        return user;
    }
}
