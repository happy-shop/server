package com.hs.core.controller;

import com.hs.common.Result;
import com.hs.core.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 2019/3/6.
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping(path = "/login/weixin")
    public Result<Object> weixinLogin(@RequestBody Map<String, Object> param) {
        log.debug("Param = {}", param);
        Result<Object> result = loginService.weixinLogin();
        return result;
    }
}
