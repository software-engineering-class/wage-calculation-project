package com.housemanager.dao;

import com.housemanager.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SalaryMapper {

    void saveSalary(Salary salary);

    void deleteSalary(Integer salary_id);

    List<Salary> selectSalaryById(String username);

    List<Salary>  selectSalaryByDate(@Param("username")String username,@Param("staffname")String staffname,@Param("dates")String dates);
    List<Salary>  selectSalaryByDates(@Param("username")String username,@Param("dates")String dates);
    List<Salary>  selectSalaryByDate1(@Param("username")String username,@Param("dates1")String dates1,@Param("dates2")String dates2);
    List<Salary> selectAllSalary();




}