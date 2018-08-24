package com.biz.service;

import com.biz.pojo.SysUser;

import java.util.List;

public interface UserService {

    public void saveUser(SysUser sysUser) throws Exception;

    public void updateUser(SysUser sysUser);

    public void deleteUser(String userId);

    public SysUser findUserById(String userId);

    public List<SysUser> findUserList();

    public List<SysUser> findUserListPaged(SysUser sysUser,Integer page,Integer pageSize);

    public SysUser findUserByIdCustom(String userId);

    public void saveUserTranscational(SysUser sysUser);

}
