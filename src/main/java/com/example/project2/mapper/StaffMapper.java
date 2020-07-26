package com.example.project2.mapper;

import com.example.project2.pojo.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author master
 */
@Mapper
@Repository
public interface StaffMapper {

    /**
     * 获取staff列表
     * @return staff列表
     */

    @Select("select * from staff")
    List<Staff> findAll();

    /**
     * 添加一条员工信息
     * @param staff 员工
     */
    @Insert("insert into staff (staffName) values (#{staffName})")
    void saveStaff(Staff staff);

    /**
     * 按员工id删除员工
     * @param staffId 员工id
     */
    @Delete("delete from  staff where staffId=#{staffId}")
    void deleteStaffById(Integer staffId);

    /**
     * 按id查询staff
     * @param staffId 员工id
     * @return 一Staff
     */
    @Select("select * from staff where staffId=#{staffId}")
    Staff getStaffById(Integer staffId);

    /**
     * 修改一条staff信息
     * @param  staffId 原本的staffId
     * @param staffName 前端传过来的修改后的staffName
     */
    @Update("Update staff set staffName=#{staffName} where staffId=#{staffId}")
    void updateStaff(String staffName,Integer staffId);

}
