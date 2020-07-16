package org.javaroute.mapper;

import org.javaroute.model.Account;

import java.util.List;

public interface AccountMapper {
    Integer getAccountById(Integer id);
    List<Account> getAllAccount();
    Integer insertAccount(Account account);
    Integer updateAccount(Account account);
    Integer deleteAccountById(Integer id);
}
