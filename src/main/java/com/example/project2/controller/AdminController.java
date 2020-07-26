package com.example.project2.controller;

import com.example.project2.pojo.Admin;
import com.example.project2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author master
 */
@RestController
@RequestMapping(value = "/admin",method = RequestMethod.GET)
public class AdminController {

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    private final AdminService adminService;

    @RequestMapping(value = "/login")
    public String login(String adminName,String adminPassword){
        return adminService.adminLogin(adminName,adminPassword)?"true":"false";
    }

    @RequestMapping(value = "/registered")
    public String registered(String adminName,String adminPassword){
        return adminService.registered(adminName,adminPassword)?"true":"false";
    }
}
