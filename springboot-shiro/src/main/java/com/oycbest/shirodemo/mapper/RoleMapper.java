package com.oycbest.shirodemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.shirodemo.domain.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author oyc
 * @since 2020-06-02 17:06:12
 */
public interface RoleMapper extends BaseMapper<Role> {

}
