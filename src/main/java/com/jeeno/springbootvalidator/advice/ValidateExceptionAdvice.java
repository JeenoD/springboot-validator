package com.jeeno.springbootvalidator.advice;

import com.alibaba.fastjson.JSONObject;
import com.jeeno.springbootvalidator.pojo.ReturnDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:08
 */
@Slf4j
@RestControllerAdvice
public class ValidateExceptionAdvice {

    @ExceptionHandler(value = BindException.class)
    public void validateExceptionHandler(HttpServletResponse response, BindException exception) throws IOException {
        log.debug("validateExceptionHandler");
        response.setContentType("application/json;charset=utf-8");
        ReturnDTO<String> result = ReturnDTO.<String>builder()
                .status(ReturnDTO.StatusEnum.FAILURE)
                .msg(exception.getAllErrors().get(0).getDefaultMessage())
                .build();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.getWriter().print(JSONObject.toJSONString(result));
        response.getWriter().flush();
    }

}
