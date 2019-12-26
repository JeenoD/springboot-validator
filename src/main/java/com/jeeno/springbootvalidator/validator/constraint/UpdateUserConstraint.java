package com.jeeno.springbootvalidator.validator.constraint;

import com.jeeno.springbootvalidator.pojo.UserDO;
import com.jeeno.springbootvalidator.service.IUserService;
import com.jeeno.springbootvalidator.validator.UpdateUserValidator;
import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:47
 */
public class UpdateUserConstraint implements ConstraintValidator<UpdateUserValidator, Long> {

    @Resource
    private IUserService userService;

    @SneakyThrows
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        UserDO userDO = userService.findById(id);
        return userDO != null;
    }
}
