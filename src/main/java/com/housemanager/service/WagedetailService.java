package com.housemanager.service;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Wagedetail;
import com.housemanager.pojo.User;
import java.util.List;

public interface WagedetailService {
    //查找
    List<User> selectAll(String username,String name,String dates);

    void saveWagedetail(Wagedetail wagedetail);

    void deleteByDates(String dates);

    PageInfo<Wagedetail> getWagedetailPage(Integer pageNum, Integer pageSize,String username,String dates);

    PageInfo<Wagedetail> getWagedetailPage(Integer pageNum, Integer pageSize,String username,String name,String dates);
}
