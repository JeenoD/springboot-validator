package com.jeeno.springbootvalidator.controller;

import com.jeeno.springbootvalidator.group.AddUserGroup;
import com.jeeno.springbootvalidator.group.DefaultGroup;
import com.jeeno.springbootvalidator.group.UpdateUserGroup;
import com.jeeno.springbootvalidator.pojo.ReturnDTO;
import com.jeeno.springbootvalidator.pojo.UserDO;
import com.jeeno.springbootvalidator.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 控制层对外接口
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 15:44
 */
@Slf4j
@RestController
public class MyController {

    @Resource
    private IUserService userService;

    @GetMapping("/user")
    public String doValidate(@Validated({DefaultGroup.class}) UserDO userDO, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors() && bindingResult.getFieldError()!= null) {
            log.error("#MyController# error while validating params. ({})", bindingResult.getFieldError().getDefaultMessage());
            throw new BindException(bindingResult);
        }
        return userDO.toString();
    }

    /**
     * add user info
     * @param userDO user info
     * @return ReturnDTO
     */
    @PostMapping("/user")
    public ReturnDTO add(@Validated({AddUserGroup.class, DefaultGroup.class}) UserDO userDO) {
        userService.save(userDO);
        return ReturnDTO.builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("add user successfully.").build();
    }

    /**
     * update user info
     * @param userDO user info
     * @return ReturnDTO
     */
    @PutMapping("/user")
    public ReturnDTO update(@Validated({UpdateUserGroup.class, DefaultGroup.class}) UserDO userDO) {
        userService.save(userDO);
        return ReturnDTO.builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("update user successfully.").build();
    }



}
