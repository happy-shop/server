package com.hs.core.service;

import com.hs.common.Result;

/**
 * Created by admin on 2019/3/6.
 */
public interface ILoginService {

    /**
     * 微信登录
     *
     * @return
     */
    Result<Object> weixinLogin();
}
