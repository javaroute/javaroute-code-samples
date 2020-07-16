package org.javaroute.service.impl;

import org.javaroute.mapper.AccountMapper;
import org.javaroute.model.Account;
import org.javaroute.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void insertAccountRecord() {
        Account account=new Account();
        account.setName("AA");
        account.setBalance(50.00d);
        accountMapper.insertAccount(account);

    }

    @Override
    public void updateAccountRecord() {

    }

    @Override
    public void deleteAccountRecord() {

    }
}
