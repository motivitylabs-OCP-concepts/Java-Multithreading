package com.motivity;

public class ThreadWithMultiple {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("in runnable 0 started");
                for (int i=0;i<10;++i)
                {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        };
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                System.out.println("in runnable 1 started");
                for (int i=10;i>0;--i)
                {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        };
        Thread thread=new Thread(runnable);
        Thread thread1=new Thread(runnable1);
        thread1.start();
        thread.start();

    }
}
