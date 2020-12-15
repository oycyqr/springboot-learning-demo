package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色信息表(BlogRole)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogRole implements Serializable {
    private static final long serialVersionUID = -13628017257888058L;
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
    * 显示顺序
    */
    private Integer roleSort;
    /**
    * 数据范围（1：全部数据权限 2：自定数据权限）
    */
    private String dataScope;
    /**
    * 角色状态（0正常 1停用）
    */
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    private String delFlag;
    /**
    * 创建者
    */
    private String createBy;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新者
    */
    private String saveOrUpdateBy;
    /**
    * 更新时间
    */
    private Date saveOrUpdateTime;
    /**
    * 备注
    */
    private String remark;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getsaveOrUpdateBy() {
        return saveOrUpdateBy;
    }

    public void setsaveOrUpdateBy(String saveOrUpdateBy) {
        this.saveOrUpdateBy = saveOrUpdateBy;
    }

    public Date getsaveOrUpdateTime() {
        return saveOrUpdateTime;
    }

    public void setsaveOrUpdateTime(Date saveOrUpdateTime) {
        this.saveOrUpdateTime = saveOrUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
