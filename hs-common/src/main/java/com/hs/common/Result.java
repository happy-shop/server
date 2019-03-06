package com.hs.common;

import lombok.Data;

/**
 * Created by admin on 2019/3/6.
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
}
