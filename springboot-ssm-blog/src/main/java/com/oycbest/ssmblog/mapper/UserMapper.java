package com.oycbest.ssmblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.ssmblog.domain.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SsmUser)表数据库访问层
 *
 * @author oyc
 * @since 2020-04-28 23:21:52
 */
public interface UserMapper extends BaseMapper<User > {

}
