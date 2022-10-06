package com.housemanager.controller;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.*;
import com.housemanager.service.SalaryService;
import com.housemanager.service.WagedetailService;
import com.housemanager.service.WageprojectService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/wagedetail")
@Controller
public class WagedetailController {

    @Autowired
    private WagedetailService wagedetailService;
    @Autowired
    private WageprojectService wageprojectService;

    @RequestMapping("/selectall")
    public String selectAll(@RequestParam(value = "pageNo", required = false, defaultValue = "1")
                                    Integer pageNum, String username, String name, String dates, Model model, HttpServletRequest req) {

        User u = (User) req.getSession().getAttribute("user");
        if (u.getStatus() == 1) {
            if (username != null) {
                PageInfo<Wagedetail> ch = wagedetailService.getWagedetailPage(pageNum, 10, username, name, dates);
                model.addAttribute("wagedetailinfo", ch);
                List<User> h = wagedetailService.selectAll(username, name, dates);
                model.addAttribute("wageprojectinfo", h);
                return "WEB-INF/jsp/wagedetail/wagedetaillist";
            } else {
                return "WEB-INF/jsp/wagedetail/wagedetaillist";
            }

        } else {
            PageInfo<Wagedetail> ch = wagedetailService.getWagedetailPage(pageNum, 10, u.getUsername(), dates);
            model.addAttribute("wagedetailinfo", ch);
            return "WEB-INF/jsp/wagedetail/wagedetaillist1";
        }

    }


    @RequestMapping("/savewagedetail")
    public String saveWagedetail() {
        return "WEB-INF/jsp/wagedetail/savewagedetail";
    }

    @RequestMapping("/wagedetailsave")
    public String saveWagedetail1(Wagedetail wagedetail) {
        /*
        调用业务逻辑层的插入方法
         */
        System.out.println(wagedetail);
        wagedetailService.saveWagedetail(wagedetail);
        return "redirect:/wagedetail/selectall";
    }

    @RequestMapping("/delete")
    public String delete(String dates) {
        wagedetailService.deleteByDates(dates);
        return "redirect:/wagedetail/selectall";
    }


    @RequestMapping("/selectWagedetailByName/{op}")
    public String selectDepartmentById(@PathVariable("op") String username, Model model) {
        model.addAttribute("username", username);
        List<Wageproject> so = wageprojectService.selectAll();
        model.addAttribute("sort", so);
        return "WEB-INF/jsp/wagedetail/updatewagedetail";
    }

    @RequestMapping("/updatewagedetail")
    public String updateWagedetail(Wagedetail wagedetail) {
        System.out.println(wagedetail);
        wagedetailService.saveWagedetail(wagedetail);
        return "redirect:/wagedetail/selectall";
    }


    @RequestMapping("/leadwagedetail")
    public String leadsalaryfile(String tupian) {
        String path = tupian;
        System.out.println(path);
        try {
            List<Wagedetail> wagedetailList = read(path);
            for (Wagedetail wagedetail : wagedetailList) {
                wagedetailService.saveWagedetail(wagedetail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/wagedetail/selectall";
    }

    public List<Wagedetail> read(String path) throws IOException {

        List<Wagedetail> wagedetailList = new ArrayList<>();
        //1.获取工作薄
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(path);

        //2.获取工作表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);
        List<Integer> list0 = new ArrayList<>();
        for (int i = 0; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row!=null) {
                if (i == 0)
                {
                    int j=0;
                    for (Cell cell : row) {
                        if (cell != null && j>3) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String value = cell.getStringCellValue();//读取数据
                            System.out.println(value);
                            Wageproject wageproject = wageprojectService.selectWageprojectByName(value);
                            list0.add(wageproject.getProjectid());
                        }
                        j++;
                    }
                }
                else {
                    List<String> list = new ArrayList<>();
                    for (Cell cell : row) {
                        if (cell != null) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String value = cell.getStringCellValue();//读取数据
                            if (value != null && !"".equals(value)) {
                                list.add(value);
                                System.out.println(value);
                            }
                        }
                    }

                    for (int j = 0;j<list0.size();j++) {
                        Wagedetail wagedetail = new Wagedetail();
                        wagedetail.setUsername(list.get(0));
                        wagedetail.setProjectid(list0.get(j));
                        wagedetail.setProjectamount(Double.parseDouble(list.get(j + 4)));
                        wagedetail.setDates(list.get(3));
                        wagedetailList.add(wagedetail);
                        System.out.println(wagedetail);
                    }
                }
            }
        }

        return wagedetailList;
    }
}