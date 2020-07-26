package com.example.project2.service;

import com.example.project2.mapper.AdminMapper;
import com.example.project2.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author master
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper){
        this.adminMapper=adminMapper;
    }

    private final AdminMapper adminMapper;

    @Override
    public List<Admin> getAdminList() {
        return adminMapper.findAll();
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.saveAdmin(admin);
    }

    @Override
    public void deleteAdminById(Integer adminId) {
        adminMapper.deleteAdmin(adminId);
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminMapper.getAdminById(adminId);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public Boolean adminLogin(String adminName,String adminPassword) {
        if(adminName!=null&&adminPassword!=null) {
            List<Admin> adminList = adminMapper.findAll();
            for (Admin testAdmin : adminList) {
                if (adminName.equals(testAdmin.getAdminName()) &&
                        (testAdmin.getAdminPassword().equals(adminPassword))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean registered( String adminName, String adminPassword) {
        if(!"".equals(adminName) && !"".equals(adminPassword)){
            List<Admin> adminList= adminMapper.findAll();
            for(Admin loop:adminList){
                if(adminName.equals(loop.getAdminName())){
                    return false;
                }
            }
            Admin admin=new Admin();
            admin.setAdminName(adminName);
            admin.setAdminPassword(adminPassword);
            adminMapper.saveAdmin(admin);
            return true;
        }
        return false;
    }
}
