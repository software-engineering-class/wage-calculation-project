package com.housemanager.service;


import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Salary;
import com.housemanager.pojo.User;

import java.util.List;

public interface UserService {
    //查找
    List<User> selectAll();

    User login(User u);
    User selectpass(User u);
    void updatepass(User u);
    void deleteById(Integer userid);
    void saveUser(User user);
    PageInfo<User> getUserPage(Integer pageNum, Integer pageSize);
    PageInfo<User> getUserPage(Integer pageNum, Integer pageSize,String username);
}
