package com.biz.mapper;

import com.biz.pojo.SysUser;
import com.biz.utils.MyMapper;

import java.util.List;

public interface SysUserMapperCustom extends MyMapper<SysUser> {

    public List<SysUser> findUserSimpleInfoById(String userId);
}