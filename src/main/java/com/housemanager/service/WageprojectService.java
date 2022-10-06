package com.housemanager.service;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Wageproject;

import java.util.List;

public interface WageprojectService {
    //查找
    List<Wageproject> selectAll();

    void saveWageproject(Wageproject wageproject);

    void deleteById(Integer projectid);

    PageInfo<Wageproject> getWageprojectPage(Integer pageNum, Integer pageSize,String projectname);

    void updateWageproject(Wageproject wageproject);

    Wageproject selectWageprojectById(Integer projectid);

    Wageproject selectWageprojectByName(String projectname);
}
