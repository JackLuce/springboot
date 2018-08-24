package com.biz.service;

import com.biz.mapper.SysUserMapper;
import com.biz.mapper.SysUserMapperCustom;
import com.biz.pojo.SysUser;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser sysUser) throws Exception {
        sysUserMapper.insert(sysUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser sysUser) {
        //会对字段进行判断，为null则忽略更新
        sysUserMapper.updateByPrimaryKeySelective(sysUser);

        //对你注入的字段全部更新
        //sysUserMapper.updateByPrimaryKey(sysUser);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser findUserById(String userId) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        return sysUser;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> findUserList() {
        List<SysUser> sysUserList = sysUserMapper.selectAll();
        return sysUserList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> findUserListPaged(SysUser sysUser, Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmptyOrWhitespaceOnly(sysUser.getNickname())){
            criteria.andLike("nickname","%"+sysUser.getNickname()+"%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> sysUserList = sysUserMapper.selectByExample(example);

        return sysUserList;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser findUserByIdCustom(String userId) {

        List<SysUser> sysUserList = sysUserMapperCustom.findUserSimpleInfoById(userId);

        if(sysUserList!=null&&!sysUserList.isEmpty()){

            SysUser sysUser = sysUserList.get(0);
            return sysUser;
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTranscational(SysUser sysUser) {

        sysUserMapper.insert(sysUser);
        System.out.println("111111111111111");

        //int a = 1/0;

        System.out.println("22222222222222222");
        sysUser.setIsDelete(1);
        System.out.println("66666666666666666666");
        sysUserMapper.updateByPrimaryKeySelective(sysUser);

    }
}
