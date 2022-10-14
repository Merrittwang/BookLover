package com.example.ereading.controller;

import com.example.ereading.domain.defaultbook;
import com.example.ereading.service.defaultbookService;
import com.example.ereading.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController extends BaseController {
    @Resource
    defaultbookService defaultbookService;
    @GetMapping({"gethistory"})
    public JsonResult<List<defaultbook>> gethistory(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<defaultbook> data = defaultbookService.Gethistorylist(uid);
        return new JsonResult<List<defaultbook>>(OK, data);
    }
    @GetMapping({"getbought"})
    public JsonResult<List<defaultbook>> getbought(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<defaultbook> data = defaultbookService.Getboughtlist(uid);
        return new JsonResult<List<defaultbook>>(OK, data);
    }
}

