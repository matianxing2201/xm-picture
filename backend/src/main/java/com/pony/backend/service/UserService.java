package com.pony.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pony.backend.model.dto.user.UserQueryRequest;
import com.pony.backend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pony.backend.model.vo.user.UserLoginVo;
import com.pony.backend.model.vo.user.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * 获取加密密码
     * @param password
     * @return
     */
    String getEncryptPassword(String password);

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


    /**
     * 获取脱敏用户信息
     * @param user
     * @return
     */
    UserVo getUserVo(User user);

    /**
     * 获取脱敏用户列表
     * @param userList
     * @return
     */
    List<UserVo> getUserVoList(List<User> userList);

    /**
     * 获取查询条件
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否管理员
     * @param user
     * @return
     */
    boolean isAdmin(User user);
}
