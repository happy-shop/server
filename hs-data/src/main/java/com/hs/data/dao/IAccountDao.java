package com.hs.data.dao;

import com.hs.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2019/3/6.
 */
@Repository
public interface IAccountDao extends JpaRepository<Account,Integer> {

}
