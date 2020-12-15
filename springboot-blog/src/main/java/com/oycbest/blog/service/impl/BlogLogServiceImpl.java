package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogLog;
import com.oycbest.blog.mapper.BlogLogMapper;
import com.oycbest.blog.service.BlogLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户操作日志表(BlogLog)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogLogService")
public class BlogLogServiceImpl extends ServiceImpl<BlogLogMapper,BlogLog> implements BlogLogService {
}
