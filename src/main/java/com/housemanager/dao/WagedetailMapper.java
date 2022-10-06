package com.housemanager.dao;

import com.housemanager.pojo.Wagedetail;
import com.housemanager.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WagedetailMapper {


    /*
向表中插入一条数据
 */
    void saveWagedetail(Wagedetail wagedetail);



    /*
    删除
     */
    void deleteWagedetail(String dates);


    /*
    查询所有的商品
     */
    List<Wagedetail> selectAllWagedetail();


    List<Wagedetail> selectByDetailname(@Param("username") String username, @Param("dates") String dates);


    /*
    查询所有的商品
     */
    List<User> selectAll(@Param("username") String username, @Param("name") String name,@Param("dates") String dates);

    /*
    查询所有的商品
     */
    List<Wagedetail> selectAllS(@Param("username") String username, @Param("name") String name,@Param("dates") String dates);



}