package com.example.ereading.service;

import com.example.ereading.domain.User;

public interface IUserService {
    void reg(User user);

    User login(String username,String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    User getByUid(Integer uid);

    void changeInfo(Integer uid,User user);
}


