package com.housemanager.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housemanager.dao.UserMapper;


import com.housemanager.pojo.User;

import com.housemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAllUser();
    }

    @Override
    public User login(User user) {
        List<User> list=userMapper.selectAll(user.getUsername(),user.getPassword());
        if(list.size()==1) return list.get(0);
        return null;
    }

    @Override
    public User selectpass(User u) {
        List<User> list=userMapper.selectPass(u.getID_card(),u.getPay_card());
        if(list.size()==1) return list.get(0);
        return null;
    }



    @Override
    public User selectById(Integer userid) {
        User user = userMapper.selectUserById(userid);
        return user;
    }

    @Override
    public void updatepass(User u) {
        userMapper.updatePass(u);
    }

    @Override
    public void updateuser(User u) {
        userMapper.updateUser(u);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);

    }

    @Override
    public PageInfo<User> getUserPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<User> hus = userMapper.selectAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(hus);
        return userPageInfo;

    }

    @Override
    public PageInfo<User> getUserPage(Integer pageNum, Integer pageSize,String username) {
        PageHelper.startPage(pageNum, pageSize);

        List<User> hus = userMapper.selectUserByName(username);
        PageInfo<User> userPageInfo = new PageInfo<>(hus);
        return userPageInfo;

    }

    @Override
    public void deleteById(Integer userid) {
        userMapper.deleteUser(userid);
    }
}
