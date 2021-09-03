package com.scj.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 22:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonRestlt<T> {
    private Integer code;
    private String message;
    private T       data;

    public CommonRestlt(Integer code, String message)
    {
        this(code, message, null);
    }

}
