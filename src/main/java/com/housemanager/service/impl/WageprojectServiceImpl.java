package com.housemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housemanager.dao.WageprojectMapper;
import com.housemanager.pojo.Wageproject;
import com.housemanager.service.WageprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WageprojectServiceImpl implements WageprojectService {
    @Autowired
    private WageprojectMapper wageprojectMapper;
    @Override
    public List<Wageproject> selectAll()
    {
        return wageprojectMapper.selectAllWageproject();
    }

    @Override
    public void saveWageproject(Wageproject wageproject) {
        wageprojectMapper.saveWageproject(wageproject);

    }

    @Override
    public void deleteById(Integer projectid) {
       wageprojectMapper.deleteWageproject(projectid);
    }

    @Override
    public PageInfo<Wageproject> getWageprojectPage(Integer pageNum, Integer pageSize,String projectname) {
        PageHelper.startPage(pageNum,pageSize);
        if(projectname!=null)
        {
            List<Wageproject> hus =wageprojectMapper.selectByProjectname(projectname);
            PageInfo<Wageproject> wageprojectPageInfo=new PageInfo<>(hus);
            return wageprojectPageInfo;
        }
        else
        {
            List<Wageproject> hus =wageprojectMapper.selectAllWageproject();
            PageInfo<Wageproject> wageprojectPageInfo=new PageInfo<>(hus);
            return wageprojectPageInfo;
        }

    }

    @Override
    public void updateWageproject(Wageproject wageproject) {
        wageprojectMapper.updateWageproject(wageproject);
    }

    @Override
    public Wageproject selectWageprojectById(Integer projectid) {
        return wageprojectMapper.selectWageprojectById(projectid);
    }

    @Override
    public Wageproject selectWageprojectByName(String projectname) {
        return wageprojectMapper.selectWageprojectByName(projectname);
    }
}
