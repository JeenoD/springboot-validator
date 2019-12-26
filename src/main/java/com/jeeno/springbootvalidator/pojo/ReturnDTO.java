package com.jeeno.springbootvalidator.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:09
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDTO<T> {

    private StatusEnum status;

    private String msg;

    private T data;

    public enum StatusEnum {
        /**
         * 成功
         */
        SUCCESS,
        /**
         * 失败
         */
        FAILURE;
    }

}
