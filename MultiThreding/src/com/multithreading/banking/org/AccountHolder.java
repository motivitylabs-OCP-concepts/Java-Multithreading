package com.multithreading.banking.org;

public class AccountHolder implements Runnable {
    private BankAccount bankAccount;
    public AccountHolder(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void run() {
        for(int i=0; i<=4; ++i)
        {
            try {
                makeWithdrawal(2000);
                if(bankAccount.getBalance()<0)
                {
                    System.out.println("not enough cash to withdrawal ");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private synchronized void makeWithdrawal(int withdrawAmount) throws InterruptedException {
        if(bankAccount.getBalance()>=withdrawAmount)
        {
            System.out.println(Thread.currentThread().getName()+"  is going to withdraw Rs "+withdrawAmount);
            Thread.sleep(3000);
            bankAccount.withdraw(withdrawAmount);
            System.out.println(Thread.currentThread().getName()+" Successfully Withdrawal Amount "+withdrawAmount);
        }
        else {
            System.out.println(Thread.currentThread().getName()+" Not enough money to withdraw ");
            System.out.println(" available balance is "+bankAccount.getBalance());
        }
    }
}
