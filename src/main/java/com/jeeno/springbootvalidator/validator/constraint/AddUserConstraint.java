package com.jeeno.springbootvalidator.validator.constraint;

import com.jeeno.springbootvalidator.pojo.UserDO;
import com.jeeno.springbootvalidator.service.IUserService;
import com.jeeno.springbootvalidator.validator.AddUserValidator;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 定义添加用户时的约束校验
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:39
 */
public class AddUserConstraint implements ConstraintValidator<AddUserValidator, String> {

    @Resource
    private IUserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        UserDO userDO = userService.findByUsername(value);
        if (userDO != null) {
            // user already exists in db.
            return false;
        }
        return true;
    }

}
