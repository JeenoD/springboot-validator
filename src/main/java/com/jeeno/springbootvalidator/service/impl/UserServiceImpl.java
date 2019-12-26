package com.jeeno.springbootvalidator.service.impl;

import com.jeeno.springbootvalidator.pojo.UserDO;
import com.jeeno.springbootvalidator.repository.UserRepository;
import com.jeeno.springbootvalidator.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:28
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void save(UserDO userDO) {
        userRepository.save(userDO);
    }

    @Override
    public UserDO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDO findById(Long id) {
        Optional optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return (UserDO)optional.get();
        }
        return null;
    }

}
