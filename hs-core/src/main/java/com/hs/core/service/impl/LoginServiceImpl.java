package com.hs.core.service.impl;

import com.hs.common.Result;
import com.hs.core.service.ILoginService;
import com.hs.db.dao.IAccountDao;
import com.hs.db.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by admin on 2019/3/6.
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Result<Object> weixinLogin() {
        Optional<Account> byId = accountDao.findById(1);
        if (!byId.isPresent()) {
            Account account = new Account();
            account.setName("测试");
            accountDao.save(account);
        }
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }
}
