package com.housemanager.service;

import com.github.pagehelper.PageInfo;

import com.housemanager.pojo.Department;

import java.util.List;

public interface DepartmentService {
    //查找
    List<Department> selectAll();

    void saveDepartment(Department department);

    void deleteById(Integer departmentid);

    PageInfo<Department> getDepartmentPage(Integer pageNum, Integer pageSize,String departmentname);

    void updateDepartment(Department department);
    Department selectDepartmentById(Integer departmentid);
}
