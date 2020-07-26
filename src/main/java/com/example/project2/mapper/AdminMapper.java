package com.example.project2.mapper;

import com.example.project2.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author master
 */
@Mapper
@Repository
public interface AdminMapper {

    /**
     * 获取所有管理员信息
     * @return 返回admin列表
     */
    @Select("select * from admin")
    List<Admin> findAll();

    /**
     * 保存一条管理员信息
     * @param admin 从前端获取的一个管理员对象
     */
    @Insert("insert into admin (adminName,adminPassword) values(#{adminName},#{adminPassword})")
    void saveAdmin(Admin admin);

    /**
     * 根据管理员id删除一条管理员信息
     * @param adminId 从前端获取的管理员id
     */
    @Delete("delete from admin where adminId=#{adminId}")
    void deleteAdmin(Integer adminId);

    /**
     * 根据id返回一条管理员信息
     * @return 返回一条管理员信息
     * @param adminId 从前端获取的一个管理员id
     */
    @Select("select * from admin where adminId=#{adminId}")
    Admin getAdminById(Integer adminId);

    /**
     * 按id修改对应管理员的值
     * @param admin 从前端获取的一个管理员对象
     */
    @Update("update admin set adminName=#{adminName},adminPassword=#{adminPassword} where adminId=#{adminId}")
    void updateAdmin(Admin admin);

}
