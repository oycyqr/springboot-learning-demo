package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogLogDao;
import com.oycbest.blog.entity.BlogLog;
import com.oycbest.blog.service.BlogLogService;
import org.springframework.stereotype.Service;

/**
 * 用户操作日志表(BlogLog)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:00
 */
@Service("blogLogService")
public class BlogLogServiceImpl extends ServiceImpl<BlogLogDao, BlogLog> implements BlogLogService {

}