package com.example.project2.service;

import com.example.project2.pojo.Staff;

import java.util.List;

/**
 * 服务层
 * @author master
 */
public interface StaffService {

    /**
     * 获取员工列表
     * @return 员工列表list
     */
    List<Staff> getStaffList();
    /**
     * 保存一条staff信息
     * @param staffName 从前端获取的一条staff姓名
     */
    void saveStaff(String staffName);

    /**
     * 按id删除一条staff信息
     * @param staffId 从前端获取的id
     */
    void deleteStaff(Integer staffId);

    /**
     * 按id查询staff
     * @param staffId 员工id
     * @return 一Staff
     */
    String getStaffById(Integer staffId);

    /**
     * 修改一条staff信息
     * @param staffName 前端传过来的修改后的staffId
     * @param staffId 原本的staffId
     */
    void updateStaff(String staffName,Integer staffId);
}
