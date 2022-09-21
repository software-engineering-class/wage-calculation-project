package com.housemanager.controller;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Salary;
import com.housemanager.pojo.User;
import com.housemanager.service.SalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/salary")
@org.springframework.stereotype.Controller
public class SalaryController {
    @Autowired
    private SalaryService salaryService;



    @RequestMapping("/selectall")
    public String selectAll(@RequestParam(value = "pageNo",required = false,defaultValue = "1")
                                    Integer pageNum, Model model,String username,String staffname,String dates,HttpServletRequest req, HttpServletResponse resp){
        User u=(User) req.getSession().getAttribute("user");
        if(u.getStatus()==0) username=u.getUsername();
        if(dates == null)
        {
            PageInfo<Salary> sh = salaryService.getSalaryPage(pageNum, 5,username);
            final Model salaryinfo = model.addAttribute("salaryinfo", sh);
        }
        else{

            PageInfo<Salary> sh = salaryService.getSalaryPage(pageNum, 5,username,staffname,dates);
            final Model salaryinfo = model.addAttribute("salaryinfo", sh);
        }


        if(u.getStatus()==1)
        {
            return "WEB-INF/jsp/salary/salarylist";
        }
        else
        {
            return "WEB-INF/jsp/salary/salarylist1";
        }

    }

    @RequestMapping("/selectall1")
    public String selectAll1(@RequestParam(value = "pageNo",required = false,defaultValue = "1")
                                    Integer pageNum, Model model,String dates,String dates1,String dates2,HttpServletRequest req, HttpServletResponse resp){
        User u=(User) req.getSession().getAttribute("user");

        PageInfo<Salary> sh = salaryService.getSalaryPage(pageNum, 5,u.getUsername(),dates,dates1,dates2);
        final Model salaryinfo = model.addAttribute("salaryinfo", sh);
        return "WEB-INF/jsp/salary/salarylist1";
    }

    @RequestMapping("/savesalary")
    public String saveSalary(){

        return "WEB-INF/jsp/salary/savesalary";
    }

    @RequestMapping("/salarysave")
    public String saveSalary1(Salary s){
        System.out.println(s);
        Double should_wage=s.getBase_wage()+s.getClass_fee()+s.getBase_performance()+s.getAge_pay()+s.getPhone_subsidy()+s.getTraffic_subsidy()+s.getOvertime_subsidy();
        Double deduct_wage=s.getLabour_insurance()+s.getUnemployment_insurance()+s.getMedical_insurance()+s.getIncome_tax()+s.getAccumulation_fund();
        Double real_wage= should_wage - deduct_wage;
        s.setShould_wage(should_wage);
        s.setDeduct_wage(deduct_wage);
        s.setReal_wage(real_wage);
        salaryService.saveSalary(s);
        return "redirect:/salary/selectall";
    }

    @RequestMapping("/delete")
    public String delete(Integer salary_id){
        salaryService.deleteById(salary_id);
        return "redirect:/salary/selectall";
    }


}
