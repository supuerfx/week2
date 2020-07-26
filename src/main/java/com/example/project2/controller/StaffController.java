package com.example.project2.controller;

import com.example.project2.pojo.Staff;
import com.example.project2.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author master
 */
@RestController
@RequestMapping("/staff")
@Api(value = "员工管理类")
public class StaffController {

    @Autowired
    public StaffController(StaffService staffService){
        this.staffService=staffService;
    }

    private final StaffService staffService;

    @RequestMapping(value = "/getStaffList",method = RequestMethod.GET)
    @ApiOperation(value = "获取staff信息",notes = "获取所有staff信息")
    public List<Staff> getStaffList(){
        return staffService.getStaffList();
    }

    @RequestMapping(value = "/saveStaff",method =RequestMethod.GET)
    @ApiOperation(value="保存staff信息",notes = "保存一条由前端页面发来的信息，之后返回staff列表")
    @ApiImplicitParam(paramType = "query",name="staff",value = "员工信息",required = true)
    @ApiResponse(code = 400,message = "无法获取参数",response = String.class)
    public List<Staff> saveStaff(String staffName){
        staffService.saveStaff(staffName);
        return staffService.getStaffList();
    }

    @RequestMapping(value = "/deleteStaffById",method = RequestMethod.GET)
    @ApiOperation(value = "删除staff信息",notes = "根据id删除单条staff信息")
    @ApiImplicitParam(paramType = "query",name="staffId",value = "员工id",required = true)
    @ApiResponse(code = 400,message = "无法获取参数",response = String.class)
    public List<Staff> deleteStaffById(Integer staffId){
        staffService.deleteStaff(staffId);
        return staffService.getStaffList();
    }

    @RequestMapping(value = "/getStaffById",method = RequestMethod.GET)
    @ApiImplicitParam(value = "员工id",name="staffId",paramType = "query",required = true)
    @ApiOperation(value = "获取员工信息",notes = "根据员工id获取单条员工信息")
    @ApiResponse(code = 400,message = "无法获取参数",response = String.class)
    public String getStaffById(Integer staffId){
        return staffService.getStaffById(staffId);
    }

    @RequestMapping(value = "/updateStaff",method = RequestMethod.GET)
    @ApiImplicitParam(value = "员工信息",name="staff",paramType = "query",required = true)
    @ApiOperation(value = "修改员工信息",notes = "修改单条员工信息")
    @ApiResponse(code = 400,message = "无法获取参数",response = String.class)
    public List<Staff> updateStaff(String staffName,Integer staffId){
        staffService.updateStaff(staffName,staffId);
        return staffService.getStaffList();
    }
}
