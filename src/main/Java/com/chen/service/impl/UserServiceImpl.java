package com.chen.service.impl;

import com.chen.dao.IUserDao;
import com.chen.model.User;
import com.chen.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public PageInfo<User> selectUser(Integer pageNum  ,Integer pageSize ) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users=this.userDao.selectUser();
        if(users == null){
            return null;
        }
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;

    }

    @Override
    public User selectFindUser(String id) {
        return userDao.selectFindUser(id);
    }
}
