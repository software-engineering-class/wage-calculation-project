package com.housemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housemanager.dao.DepartmentMapper;
import com.housemanager.pojo.Department;
import com.housemanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> selectAll()
    {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentMapper.saveDepartment(department);

    }

    @Override
    public void deleteById(Integer departmentid) {
        departmentMapper.deleteDepartment(departmentid);

    }

    @Override
    public PageInfo<Department> getDepartmentPage(Integer pageNum, Integer pageSize,String departmentname) {
        PageHelper.startPage(pageNum,pageSize);
        if(departmentname!=null)
        {
            List<Department> hus = departmentMapper.selectDepartmentByName(departmentname);
            PageInfo<Department> departmentPageInfo=new PageInfo<>(hus);
            return departmentPageInfo;
        }
        else {
            List<Department> hus = departmentMapper.selectAllDepartment();
            PageInfo<Department> departmentPageInfo=new PageInfo<>(hus);
            return departmentPageInfo;
        }

    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public Department selectDepartmentById(Integer departmentid) {
        return departmentMapper.selectDepartmentById(departmentid);
    }
}
