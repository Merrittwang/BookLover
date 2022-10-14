package com.example.ereading.service.implementation;

import com.example.ereading.domain.User;
import com.example.ereading.mapper.UserMapper;
import com.example.ereading.service.IUserService;
import com.example.ereading.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImplementation implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        String username = user.getUsername();

        User result = userMapper.findByUsername(username);

        if (result != null) {
            throw new DuplicateUsernameException("This username is already used by others.");
        }

        if(!user.getRepeatPassword().equals(user.getPassword())){
            throw new PasswordErrorException("Please confirm password is the same.");
        }



        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);


        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("Unknown exception for register.");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UsernameErrorException("This user dose not exist.");
        }

        String dataPassword = result.getPassword();

        if (!password.equals(dataPassword)) {
            throw new PasswordErrorException("Password is wrong.");
        }


        if (result.getIsDelete() == 1) {
            throw new UsernameErrorException("This user dose not exist.");
        }

        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {

        User result = userMapper.findByUid(uid);

        if (result ==null || result.getIsDelete() == 1) {
            throw new UsernameErrorException("This user dose not exist.");
        }


        if (!result.getPassword().equals(oldPassword)) {
            throw new PasswordErrorException("Wrong password.");
        }

        Integer rows = userMapper.updatePasswordByUid(uid, newPassword, username, new Date());

        if (rows != 1) {
            throw new UpdateException("Unknown exception for information updating.");
        }
    }

    @Override
    public User getByUid(Integer uid) {

        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameErrorException("user not exists");
        }


        User user = new User();
        user.setUsername(result.getUsername());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }


    @Override
    public void changeInfo(Integer uid, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameErrorException("user not exists");
        }
        user.setUid(uid);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);
        if (rows!=1) {
            throw new UpdateException("error in updating");
        }
    }
}