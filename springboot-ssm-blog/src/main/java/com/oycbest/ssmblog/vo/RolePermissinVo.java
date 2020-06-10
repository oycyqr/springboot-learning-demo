package com.oycbest.ssmblog.vo;

import com.oycbest.ssmblog.domain.Permission;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * 角色信息表(Role)实体类
 *
 * @author oyc
 * @since 2020-06-02 22:00:50
 */
@Data
public class RolePermissinVo implements Serializable {
	private static final long serialVersionUID = 701289727275264342L;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色权限字符串
	 */
	private String roleKey;
	/**
	 * 权限
	 */
	private Set<Permission> perms;
}
