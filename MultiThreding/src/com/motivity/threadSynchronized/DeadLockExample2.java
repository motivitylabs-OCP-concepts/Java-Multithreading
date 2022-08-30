package com.motivity.threadSynchronized;

public class DeadLockExample2 {

    public static void main(String[] args) {
        final String resource1 ="printer ";
        final String resource2 ="scanner";
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + "  locked " + resource1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + "  locked " + resource2);
                    }
                }}
        };
        Runnable runnable2=new Runnable() {
            @Override
            public void run() {
                synchronized (resource2)
                {
                    System.out.println(Thread.currentThread().getName()+"  locked "+resource2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (resource1)
                    {
                        System.out.println(Thread.currentThread().getName()+"  locked "+resource1);
                    }
                }
            }
        };
        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);
        thread1.setName("Laptop ");
        thread2.setName("Desktop ");
        thread1.start();
        thread2.start();
    }
}

