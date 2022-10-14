package com.example.ereading.controller;

import com.example.ereading.domain.VIP;
import com.example.ereading.service.VIPService;
import com.example.ereading.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("vip")
public class VIPController extends BaseController{
    @Resource
    VIPService VIPService;

    @GetMapping({"getByuid"})
    public JsonResult<VIP> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        VIP data =VIPService.Getall(uid);
        return new JsonResult<VIP>(OK, data);
    }
    @GetMapping({"getByuid2"})
    public JsonResult<VIP> getByUid2(HttpSession session) {
        VIP data =VIPService.Getall(1);
        return new JsonResult<VIP>(OK, data);
    }
    @RequestMapping("buypoints")
    public JsonResult<Void> buypoints(HttpSession session) {
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行修改用户资料
        VIPService.Buypoints(uid);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
    @RequestMapping("buyvip")
    public JsonResult<Void> buyvip(HttpSession session) {
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行修改用户资料
        VIPService.Buyvip(uid);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
    @RequestMapping("paybook")
    public JsonResult<Void> paybook(Integer i,HttpSession session) {
        Integer uid = getUidFromSession(session);
        VIP data =VIPService.Getall(uid);
        if(data.getPoints()>i) {
            // 调用业务对象执行修改用户资料
            VIPService.paybook(i, uid);
            return new JsonResult<Void>(OK);
        }
        else{
            return new JsonResult<Void>(500);
        }
    }
    @RequestMapping("buypoints2")
    public JsonResult<Void> buypoints2(HttpSession session) {
        // 调用业务对象执行修改用户资料
        VIPService.Buypoints(1);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
}
