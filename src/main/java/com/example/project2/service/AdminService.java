package com.example.project2.service;

import com.example.project2.pojo.Admin;

import java.util.List;

/**
 * @author master
 */
public interface AdminService {

    /**
     * 返回所有管理员的信息列表
     * @return 所有管理员列表
     */
    List<Admin> getAdminList();

    /**
     * 保存一条管理员信息
     * @param admin 从前端获取一条管理员信息
     */
    void saveAdmin(Admin admin);

    /**
     * 按id删除一条管理员信息
     * @param adminId 从前端获取的一个管理员id
     */
    void deleteAdminById(Integer adminId);

    /**
     * 按管理员id返回一条对应的管理员信息
     * @param adminId 从前端获取的一个管理员id
     * @return 返回一条管理员信息
     */
    Admin getAdminById(Integer adminId);

    /**
     * 修改原管理员信息，id保持不变
     * @param admin 从前端获取一条admin信息
     */
    void updateAdmin(Admin admin);

    /**
     * 管理员登录功能
     * @param adminName 从前端获取的一条管理员用户名
     * @param adminPassword 从前端获取的一条管理员密码
     * @return 返回匹配结果
     */
    Boolean adminLogin(String adminName,String adminPassword);

    /**
     * 管理员注册
     * @param adminName
     * @param adminPassword
     * @return
     */
    Boolean registered(String adminName,String adminPassword);
}
