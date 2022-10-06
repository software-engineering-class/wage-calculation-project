package com.housemanager.controller;

import com.github.pagehelper.PageInfo;

import com.housemanager.pojo.Department;
import com.housemanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/department")
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/selectall")
    public String selectAll(@RequestParam(value = "pageNo",required = false,defaultValue = "1")
                                        Integer pageNum,Model model,String departmentname){
        PageInfo<Department> ch = departmentService.getDepartmentPage(pageNum, 5,departmentname);

        model.addAttribute("departmentinfo",ch);

        return "WEB-INF/jsp/department/departmentlist";
    }
    @RequestMapping("/savedepartment")
    public String saveDepartment(){
        return "WEB-INF/jsp/department/savedepartment";
    }

    @RequestMapping("/departmentsave")
    public String savedepartment1(Department department){

        departmentService.saveDepartment(department);
        return "redirect:/department/selectall";
    }

    @RequestMapping("delete")
    public String delete(Integer departmentid){
        departmentService.deleteById(departmentid);
        return "redirect:/department/selectall";
    }


    @RequestMapping("/selectDepartmentById/{op}")
    public String selectDepartmentById(@PathVariable("op") Integer departmentid, Model model){
        Department department=departmentService.selectDepartmentById(departmentid);
        model.addAttribute("hu",department);
        return "WEB-INF/jsp/department/updatedepartment";
    }

    @RequestMapping("/updatedepartment")
    public String updatedepartment(Department department) {

        departmentService.updateDepartment(department);

        return "redirect:/department/selectall";
    }


}
