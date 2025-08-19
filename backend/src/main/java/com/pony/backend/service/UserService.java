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
    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    UserLoginVo userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    User getUserLogin(HttpServletRequest request);

    /**
     * 获取当前登录用户信息 脱敏
     * @param user
     * @return
     */
    UserLoginVo getLoginUserVo(User user);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest  request);
}
