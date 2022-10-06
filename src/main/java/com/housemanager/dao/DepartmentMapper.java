package com.housemanager.dao;

import com.housemanager.pojo.Department;

import java.util.List;

import com.housemanager.pojo.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {

    /*
向表中插入一条数?
 */
    void saveDepartment(Department department);

    /*
    更新
     */
    void updateDepartment(Department department);

    /*
    删除
     */
    void deleteDepartment(Integer departmentid);

    /*
    根据房源编号查询房源信息
     */
    Department selectDepartmentById(Integer departmentid);

    /*
    查询所有的商品
     */
    List<Department> selectAllDepartment();

    List<Department> selectDepartmentByName(String departmentname);

}