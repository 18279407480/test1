package com.chen.dao;
import com.chen.model.User;

import java.util.List;

public interface IUserDao {

   List<User>  selectUser();

   User selectFindUser(String id);

}
