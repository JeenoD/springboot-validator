package com.jeeno.springbootvalidator.validator;

import com.jeeno.springbootvalidator.validator.constraint.AddUserConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:37
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddUserConstraint.class)
public @interface AddUserValidator {
    /**
     * 提示信息
     * @return String
     */
    String message() default "该用户已存在";

    /**
     * 校验分组
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
