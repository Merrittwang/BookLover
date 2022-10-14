package com.example.ereading.controller;

//import com.cy.store.controller.ex.*;
//import com.cy.store.service.ex.*;
import com.example.ereading.service.ServiceException;
import com.example.ereading.service.exception.*;
import com.example.ereading.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof DuplicateUsernameException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用的异常");
        } else if (e instanceof UsernameErrorException) {
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordErrorException) {
            result.setState(4002);
            result.setMessage("用户名密码错误的异常");
        }  else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("插入数据时产生未知的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        }
        return result;
    }
}