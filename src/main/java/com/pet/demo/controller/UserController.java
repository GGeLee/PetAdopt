package com.pet.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.pet.demo.config.Log;
import com.pet.demo.entity.User;
import com.pet.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/front")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/user")
    public String findAll(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "searchName",required = false) String searchName){
//        model.addAttribute("url", "/front/user");
        if(StringUtils.isEmpty(searchName)){
            PageHelper.startPage(pageNum,5);
//            String userList1 = stringRedisTemplate.opsForValue().get("userList");
//            System.out.println(userList1);
//            if (StrUtil.isNotBlank(userList1)){
//                List<User> userList = JSONUtil.toList(userList1, User.class);
//                PageInfo<User> pageInfo = new PageInfo<>(userList);
//                model.addAttribute("pagelist",pageInfo);
//                return "user_b";
//            }else{
                List<User> userList=userService.findAll();
                stringRedisTemplate.opsForValue().set("userList", JSONUtil.toJsonStr(userList),5, TimeUnit.MINUTES);
                PageInfo<User> pageInfo = new PageInfo<>(userList);
                model.addAttribute("pagelist",pageInfo);
                return "user_b";
//            }


        }
        else {
            String name='%'+searchName+'%';
            PageHelper.startPage(pageNum,5);
            List<User> users=userService.findByName(name);
            PageInfo<User> pageInfo = new PageInfo<>(users);
            model.addAttribute("pagelist",pageInfo);
            return "user_b";
        }
    }

    @PostMapping("/save")
    public String save( User user){
        //        判断添加还是修改操作
        if(StringUtils.isEmpty(user.getUserId())){
                userService.save(user);
        }else {
            userService.update(user);
        }
        return "redirect:/front/user";
    }
    @PostMapping("/infoUpdate")
    public String infoUpdate(User user, HttpSession session, RedirectAttributes attributes){
        userService.update(user);
        session.setAttribute("user",user);
        attributes.addFlashAttribute("message","保存成功");
        return "redirect:/info";
    }
    @PostMapping("/updatePsd")
    @ResponseBody
    public String updatePsd( String oldPassword,String newPassword,String psdId
                             )  {
        User user = userService.findOne(psdId);
        String msg = "0";
        if(oldPassword.isEmpty()){
            return msg;
        }
        if(oldPassword.equals(user.getUserPassword())){
            user.setUserPassword(newPassword);
            userService.update(user);
           msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;
    }

    @GetMapping("/findByName")
    public String findByName( Model model, @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(name = "searchName",required = false) String searchName){
        String name="%"+searchName+"%";
        PageHelper.startPage(pageNum,5);
        List<User> users=userService.findByName(name);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("users",pageInfo);
        return "user_b";
    }
    @GetMapping("/delete")
    public String delete( String userId){
        userService.delete(userId);
        return "redirect:/front/user";
    }


}
