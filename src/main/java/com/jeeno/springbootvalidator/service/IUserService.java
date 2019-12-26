package com.jeeno.springbootvalidator.service;

import com.jeeno.springbootvalidator.pojo.UserDO;

/**
 * 用户相关的业务层接口
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:26
 */
public interface IUserService {

    /**
     * save user (add when id is null. update when id is not null)
     * @param userDO user info
     */
    void save(UserDO userDO);

    /**
     * query for user info by username
     * @param username username
     * @return UserDO
     */
    UserDO findByUsername(String username);

    /**
     * query for user info by id
     * @param id id
     * @return UserDO
     */
    UserDO findById(Long id);
}
