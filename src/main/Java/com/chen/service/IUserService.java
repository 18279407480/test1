package com.chen.service;

import com.chen.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {

    PageInfo<User> selectUser(Integer pageNum  , Integer pageSize);

    User selectFindUser(String id);
}
