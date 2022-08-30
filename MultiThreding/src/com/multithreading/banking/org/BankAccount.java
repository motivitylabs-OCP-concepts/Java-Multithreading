package com.multithreading.banking.org;

public class BankAccount {
    private long ac_balance=6000 ;
     public long getBalance()
     {
         return ac_balance;

     }
     public void withdraw(long amount)
     {
         ac_balance=ac_balance-amount;
     }
}
