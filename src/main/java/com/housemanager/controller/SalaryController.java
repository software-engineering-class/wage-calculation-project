package com.housemanager.controller;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Salary;
import com.housemanager.pojo.User;
import com.housemanager.service.SalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import java.io.IOException;

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

    @RequestMapping("/leadsalary")
    public String leadsalaryfile(String tupian) {
       // String fileName=tupian.getOriginalFilename().replace(".xlsx","-");
       // String path = "D:\\upload\\";
        String path = tupian;
        System.out.println(path);
        try {
            List<Salary> salaryList = read(path);
            for (Salary salary : salaryList) {
                salaryService.saveSalary(salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/salary/selectall";
    }

    public static  List<Salary> read(String path) throws IOException{
        List<Salary> salaryList=new ArrayList<>();
        //1.获取工作薄
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(path);
        //2.获取工作表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <=lastRowNum ; i++) {
            XSSFRow row = sheet.getRow(i);
            if(row!=null){
                List<String> list=new ArrayList<>();
                for (Cell cell : row) {
                    if(cell!=null){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String value = cell.getStringCellValue();//读取数据
                        if(value!=null&&!"".equals(value)) {
                            list.add(value);
                        }
                    }
                }
                if(list.size()>0) {
                    Salary salary = new Salary(list.get(0), list.get(1), list.get(2)
                            ,Double.parseDouble(list.get(3)),Double.parseDouble(list.get(4)),Double.parseDouble(list.get(5))
                            ,Double.parseDouble(list.get(6)),Double.parseDouble(list.get(7)),Double.parseDouble(list.get(8))
                            ,Double.parseDouble(list.get(9)),Double.parseDouble(list.get(10)),Double.parseDouble(list.get(11))
                            ,Double.parseDouble(list.get(12)),Double.parseDouble(list.get(13)),Double.parseDouble(list.get(14))
                            ,Double.parseDouble(list.get(15)),Double.parseDouble(list.get(16)),Double.parseDouble(list.get(17)));
                    salaryList.add(salary);
                    System.out.println(salary);
                }
            }
        }
        return salaryList;
    }


}
