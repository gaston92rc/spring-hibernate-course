package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
    private Account account;

    public void addAccount(Account account, boolean flag){
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNG");
        this.account = account;
    }



    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(){

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("Gaston","Silver");
        Account account2 = new Account("Marlene","Platinum");
        Account account3 = new Account("Lucas","Gold");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;

    }
}
