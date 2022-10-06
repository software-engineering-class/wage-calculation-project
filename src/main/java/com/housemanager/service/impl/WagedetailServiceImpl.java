package com.housemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housemanager.dao.WagedetailMapper;
import com.housemanager.pojo.User;
import com.housemanager.pojo.Wagedetail;
import com.housemanager.service.WagedetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagedetailServiceImpl implements WagedetailService {
    @Autowired
    private WagedetailMapper wagedetailMapper;


    @Override
    public List<User> selectAll(String username, String name, String dates) {
        return wagedetailMapper.selectAll(username, name, dates);
    }

    @Override
    public void saveWagedetail(Wagedetail wagedetail) {
        wagedetailMapper.saveWagedetail(wagedetail);
    }

    @Override
    public void deleteByDates(String dates) {
        wagedetailMapper.deleteWagedetail(dates);
    }



    @Override
    public PageInfo<Wagedetail> getWagedetailPage(Integer pageNum, Integer pageSize,String username,String dates) {

        PageHelper.startPage(pageNum,pageSize);
        if(dates!=null)
        {
            List<Wagedetail> hus = wagedetailMapper.selectByDetailname(username, dates);
            PageInfo<Wagedetail> wagedetailPageInfo=new PageInfo<>(hus);
            return wagedetailPageInfo;
        }
        else
        {
            List<Wagedetail> hus = wagedetailMapper.selectAllWagedetail();
            PageInfo<Wagedetail> wagedetailPageInfo=new PageInfo<>(hus);
            return wagedetailPageInfo;
        }

    }


    @Override
    public PageInfo<Wagedetail> getWagedetailPage(Integer pageNum, Integer pageSize,String username,String name,String dates) {

        PageHelper.startPage(pageNum,pageSize);
        if(username!=null)
        {
            List<Wagedetail> hus = wagedetailMapper.selectAllS(username, name, dates);
            PageInfo<Wagedetail> wagedetailPageInfo=new PageInfo<>(hus);
            return wagedetailPageInfo;
        }
        else
        {

            List<Wagedetail> hus = wagedetailMapper.selectAllWagedetail();
            PageInfo<Wagedetail> wagedetailPageInfo=new PageInfo<>(hus);
            return wagedetailPageInfo;
        }

    }
}
