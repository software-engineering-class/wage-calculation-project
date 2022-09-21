package com.housemanager.dao;


import com.housemanager.pojo.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    List<User> selectAllUser();
    List<User> selectAll(@Param("username") String username,@Param("password") String password);
    void updatePass(User user);


    List<User> selectPass(@Param("ID_card") String ID_card,@Param("pay_card") String pay_card);

    int insert(User record);
    List<User> selectUserById(String username);

    void saveUser(User user);
    void deleteUser(Integer userid);
}