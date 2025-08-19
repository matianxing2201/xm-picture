package com.pony.backend.service;

import com.pony.backend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pony.backend.model.vo.user.UserLoginVo;

import javax.servlet.http.HttpServletRequest;

/**
* @author mtx
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-08-18 16:20:29
*/
public interface UserService extends IService<User> {
    long userRegister(String userAccount, String userPassword, String checkPassword);

    UserLoginVo userLogin(String userAccount, String userPassword, HttpServletRequest request);

}
