package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingingDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
            boolean flag = true;
            accounts = accountDAO.findAccounts(flag);
        } catch (Exception e) {
            System.out.println("\n\nMain Program ... caught exception: " + e);
        }

        System.out.println("\n\nMain Program: AfterThrowingingDemoApp");
        System.out.println("---");
        System.out.println(accounts);
        System.out.println("\n");
        context.close();
    }
}
