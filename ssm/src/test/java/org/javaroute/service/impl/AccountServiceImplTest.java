package org.javaroute.service.impl;

import org.javaroute.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {
    ApplicationContext ac;
    @Before
    public void setUp() throws Exception {
        //加载配置
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml.bak");

    }

    @Test
    public void insertAccountRecord() {
        AccountService as = (AccountService) ac.getBean("accountService");
        as.insertAccountRecord();
    }

    @Test
    public void updateAccountRecord() {
    }

    @Test
    public void deleteAccountRecord() {
    }
}