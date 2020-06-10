package com.oycbest.ssmblog.controller;

import com.oycbest.ssmblog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oyc
 */
@Slf4j
@RestController
@RequestMapping("/sys/common")
public class CommonController {
	/**
	 * @return
	 * @Author 政辉
	 */
	@GetMapping("/403")
	public Result noauth() {
		return Result.error("没有权限，请联系管理员授权");
	}
}
