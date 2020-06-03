package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.SsmBlogList;
import com.oycbest.ssmblog.mapper.SsmBlogListMapper;
import com.oycbest.ssmblog.service.SsmBlogListService;
import org.springframework.stereotype.Service;

/**
 * (SsmBlogList)表服务实现类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Service("ssmBlogListService")
public class SsmBlogListServiceImpl extends ServiceImpl<SsmBlogListMapper, SsmBlogList> implements SsmBlogListService {

}
