package com.housemanager.controller;

import com.github.pagehelper.PageInfo;
import com.housemanager.pojo.User;
import com.housemanager.service.UserService;
import com.housemanager.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public void login(User u,HttpServletRequest req, HttpServletResponse resp){

        User current=userService.login(u);
        System.out.println("2222");
        try {
            if(current==null){
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }else{
                if(current.getStatus()==1)
                {
                    HttpSession s=req.getSession();
                    s.setAttribute("user", current);
                    resp.sendRedirect(req.getContextPath()+"/index.jsp");
                }
                else
                {
                    HttpSession s=req.getSession();
                    s.setAttribute("user", current);
                    System.out.println("bbb");
                    resp.sendRedirect(req.getContextPath()+"/index1.jsp");
                }


            }
        } catch (IOException e) {
        }
    }

    @RequestMapping("/selectall")
    public String selectAll(@RequestParam(value = "pageNo",required = false,defaultValue = "1")
                                    Integer pageNum,String username,Model model){
        if(username!=null)
        {
            PageInfo<User> sh = userService.getUserPage(pageNum, 5,username);
            final Model userinfo = model.addAttribute("userinfo", sh);
        }
        else
        {
            PageInfo<User> sh = userService.getUserPage(pageNum, 5);
            final Model userinfo = model.addAttribute("userinfo", sh);
        }

        return "WEB-INF/jsp/user/userlist";
    }


    @RequestMapping("/saveuser")
    public String saveUser(){

        return "WEB-INF/jsp/user/register";
    }

    @RequestMapping("/savepassword")
    public String savePassword(){

        return "WEB-INF/jsp/user/password";
    }


    @RequestMapping("/passwordsave")
    public String savePassword(String ID_card,String pay_card,Model model) throws IOException {
        User user=new User();
        user.setID_card(ID_card);
        user.setPay_card(pay_card);
        User current = userService.selectpass(user);
        model.addAttribute("user",current);
        return "WEB-INF/jsp/user/password";
    }

    @RequestMapping("/usersave")
    public void saveUser1(String username,String password1,String password2,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password1);
        user.setStatus(0);
        System.out.println(user.toString());
        userService.saveUser(user);
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }


    @RequestMapping("/repass")
    public @ResponseBody ResultJson repass(String password, String password1, String password2, HttpServletRequest req, HttpServletResponse resp){
        System.out.println(password+password1+password2);
        User u=(User) req.getSession().getAttribute("user");
        System.out.println(u);
        if(!u.getPassword().equals(password)) return new ResultJson(-2);
        u.setPassword(password1);
        userService.updatepass(u);
        return new ResultJson(1);
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除Session
        //session.removeAttribute("login");
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:/user/login";
    }

    @RequestMapping("delete")
    public String delete(Integer userid){
        userService.deleteById(userid);
        return "redirect:/user/selectall";
    }
}
