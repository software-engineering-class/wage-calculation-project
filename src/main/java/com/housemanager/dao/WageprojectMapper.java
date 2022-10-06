package com.housemanager.dao;

import com.housemanager.pojo.Wageproject;

import java.util.List;


public interface WageprojectMapper {


    /*
向表中插入一条数据
 */
    void saveWageproject(Wageproject wageproject);

    /*
    更新
     */
    void updateWageproject(Wageproject wageproject);

    /*
    删除
     */
    void deleteWageproject(Integer projectid);

    /*
    根据房源编号查询房源信息
     */
    Wageproject selectWageprojectById(Integer projectid);

    /*
    查询所有的商品
     */
    List<Wageproject> selectAllWageproject();
    List<Wageproject> selectByProjectname(String projectname);

    Wageproject selectWageprojectByName(String projectname);
}