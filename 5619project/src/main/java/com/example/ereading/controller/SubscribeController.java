package com.example.ereading.controller;

import com.example.ereading.domain.defaultuser;
import com.example.ereading.service.SubscribeService;
import com.example.ereading.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("subscribe")
public class SubscribeController extends BaseController{
    @Resource
    SubscribeService SubscribeService;
    @GetMapping({"getByuid"})
    public JsonResult<List<Integer>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Integer> data = SubscribeService.Getlist(uid);
        return new JsonResult<List<Integer>>(OK, data);
    }
    @GetMapping({"getByuid2"})
    public JsonResult<List<defaultuser>> getByUid2(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<defaultuser> data = SubscribeService.Getlist2(uid);
        return new JsonResult<List<defaultuser>>(OK, data);
    }
    @RequestMapping("add")
    public JsonResult<Void> add(HttpSession session,Integer id) {
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行修改用户资料
        SubscribeService.add(uid,id);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
    @RequestMapping("delete")
    public JsonResult<Void> delete(HttpSession session,Integer id) {
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行修改用户资料
        SubscribeService.add(uid,id);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
}
