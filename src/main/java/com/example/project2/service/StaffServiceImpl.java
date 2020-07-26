package com.example.project2.service;

import com.example.project2.mapper.StaffMapper;
import com.example.project2.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现
 * @author master
 */
@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    public StaffServiceImpl(StaffMapper staffMapper){
        this.staffMapper=staffMapper;
    }
    private final StaffMapper staffMapper;


    @Override
    public List<Staff> getStaffList() {
        return staffMapper.findAll();
    }

    @Override
    public void saveStaff(String staffName) {
        Staff staff=new Staff();
        staff.setStaffName(staffName);
        staffMapper.saveStaff(staff);
    }

    @Override
    public void deleteStaff(Integer staffId) {
        staffMapper.deleteStaffById(staffId);
    }

    @Override
    public String getStaffById(Integer staffId) {
        List<Staff> staffList = staffMapper.findAll();
        for(Staff test:staffList){
            if(test.getStaffId().equals(staffId)){
                return staffMapper.getStaffById(staffId).getStaffName();
            }
        }
        return "查询的员工不存在";
    }

    @Override
    public void updateStaff(String staffName,Integer staffId) {
        staffMapper.updateStaff(staffName,staffId);
    }
}
