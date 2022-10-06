package com.housemanager.service;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Salary;

import java.util.List;

public interface SalaryService {
    //查找
    List<Salary> selectAll();

    void deleteById(Integer salary_id);

    void saveSalary(Salary salary);

    PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username);

    PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username,String dates,String dates1,String dates2);

    PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username,String staffname,String dates);






}
