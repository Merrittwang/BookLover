package com.example.ereading.controller;

import com.example.ereading.domain.User;
import com.example.ereading.service.IUserService;
import com.example.ereading.service.exception.InsertException;
import com.example.ereading.util.JsonResult;
import com.example.ereading.service.exception.DuplicateUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
//@Controller
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")

    public JsonResult<Void> reg(User user) {
        System.out.println(user);
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {

        User data = userService.login(username, password);


        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());


        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<User>(OK,data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getUidFromSession(session));
        return new JsonResult<User>(OK,data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session) {
        //user对象中有四部分的数据:username,phone,email,gender
        //控制层给业务层传递uid,并在业务层通过user.setUid(uid);将uid封装到user中
        Integer uid = getUidFromSession(session);
        userService.changeInfo(uid,user);
        return new JsonResult<>(OK);
    }
}

