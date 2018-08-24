package com.biz.mapper;

import com.biz.pojo.SysUser;
import com.biz.utils.MyMapper;

import java.util.List;
/**
自定义mapper映射
*/
public interface SysUserMapperCustom extends MyMapper<SysUser> {

    public List<SysUser> findUserSimpleInfoById(String userId);
}