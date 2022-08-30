package com.multithreading.banking.org;

public class ClintAtm {
    public static void main(String[] args) {

        BankAccount bankAccount=new BankAccount();
        AccountHolder accountHolder=new AccountHolder(bankAccount);
        Thread thread1=new Thread(accountHolder);
        Thread thread2=new Thread(accountHolder);
        thread1.setName("hari");
        thread2.setName("bhaskar");
       thread1.start();
       thread2.start();
    }
}
