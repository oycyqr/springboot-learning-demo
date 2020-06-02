package com.oycbest.ssmblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.ssmblog.domain.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author oyc
 * @since 2020-06-02 22:00:50
 */
public interface RoleMapper extends BaseMapper<Role> {
}
