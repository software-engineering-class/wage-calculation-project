package com.housemanager.controller;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.Wageproject;
import com.housemanager.service.WageprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/wageproject")
@Controller
public class WageprojectController {
    @Autowired
    private WageprojectService wageprojectService;
    @RequestMapping("/selectall")
    public String selectAll(@RequestParam(value = "pageNo",required = false,defaultValue = "1")
                                        Integer pageNum,Model model,String projectname){
        PageInfo<Wageproject> ch = wageprojectService.getWageprojectPage(pageNum, 10,projectname);

        final Model wageprojectinfo = model.addAttribute("wageprojectinfo",ch);

        return "WEB-INF/jsp/wageproject/wageprojectlist";
    }


    @RequestMapping("/savewageproject")
    public String saveWageproject(){

        return "WEB-INF/jsp/wageproject/savewageproject";
    }

    @RequestMapping("/wageprojectsave")
    public String saveWageproject1(Wageproject wageproject){
        /*
        调用业务逻辑层的插入方法
         */
        System.out.println(wageproject);
        wageprojectService.saveWageproject(wageproject);
        return "redirect:/wageproject/selectall";
    }

    @RequestMapping("delete")
    public String delete(int projectid){
        wageprojectService.deleteById(projectid);
        return "redirect:/wageproject/selectall";
    }


    @RequestMapping("/selectWageprojectById/{op}")
    public String selectWageprojectById(@PathVariable("op") Integer projectid, Model model){
        Wageproject wageproject=wageprojectService.selectWageprojectById(projectid);
        model.addAttribute("hu",wageproject);
        return "WEB-INF/jsp/wageproject/updatewageproject";
    }

    @RequestMapping("/updatewageproject")
    public String updateWageproject(Wageproject wageproject) {

        System.out.println(wageproject);

        wageprojectService.updateWageproject(wageproject);

        return "redirect:/wageproject/selectall";
    }


}
