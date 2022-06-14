package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {
    private String name;
    private String address;
    private String phoneNumber;
    final private List<Accountable> accounts = new ArrayList<>();

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public Accountable[] getAccounts(){
        Accountable[] accountArray = new Accountable[accounts.size()];
        accountArray = accounts.toArray(accountArray);
        return accountArray;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
    }

    public boolean isVip(){
        int sum = 0;
        for(Accountable total : accounts) {
           sum += total.getBalance();
        }
        if(sum>=25000){
            return true;
        } else {
            return false;
        }
    }

}




