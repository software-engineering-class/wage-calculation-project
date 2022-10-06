package com.housemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housemanager.dao.SalaryMapper;
import com.housemanager.pojo.Salary;
import com.housemanager.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> selectAll() {
        return salaryMapper.selectAllSalary();
    }



    @Override
    public void  saveSalary(Salary salary){
        salaryMapper.saveSalary(salary);
    }

    @Override
    public void deleteById(Integer salary_id) {
        salaryMapper.deleteSalary(salary_id);
    }

    @Override
    public PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username) {
        PageHelper.startPage(pageNum, pageSize);
        if(username!=null)
        {
            List<Salary> hus = salaryMapper.selectSalaryById(username);
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }
        else
        {
            List<Salary> hus = salaryMapper.selectAllSalary();
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }

    }

    @Override
    public PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username,String dates,String dates1,String dates2) {
        PageHelper.startPage(pageNum, pageSize);
        if(dates!=null)
        {
            List<Salary> hus = salaryMapper.selectSalaryByDates(username, dates);
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }
        else
        {
            List<Salary> hus = salaryMapper.selectSalaryByDate1(username, dates1, dates2);
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }

    }

    @Override
    public PageInfo<Salary> getSalaryPage(Integer pageNum, Integer pageSize,String username,String staffname,String dates) {
        PageHelper.startPage(pageNum, pageSize);
        if(staffname!=null)
        {
            List<Salary> hus = salaryMapper.selectSalaryByDate(username,staffname,dates);
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }
        else
        {
            List<Salary> hus = salaryMapper.selectSalaryByDates(username,dates);
            PageInfo<Salary> salaryPageInfo = new PageInfo<>(hus);
            return salaryPageInfo;
        }
    }




}
