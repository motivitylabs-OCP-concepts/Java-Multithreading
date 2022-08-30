package com.motivity.threadClassMethods;

class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println("i am   "+Thread.currentThread().getName()+" printing");
    }
}
public class GetNameMethods {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("first created thread  name "+Thread.currentThread().getName());
        MyThread myThread=new MyThread();
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();

        System.out.println("my thread 1 name "+myThread.getName());//getname method returns this thread name
        System.out.println("my thread 2 name "+myThread1.getName());//getname method returns this thread name
        System.out.println("my thread 3 name "+myThread2.getName());//getname method returns this thread name

        myThread.start();
        myThread1.start();
        myThread2.start();

        myThread.setName("firstThread");
        System.out.println("number of active threads "+Thread.activeCount());
        System.out.println(myThread.getName()+" is alive  "+ myThread.isAlive());// alive method is returns current thread is alive
        System.out.println("id of the thread "+myThread.getId());//get id method returns id of the thread
        System.out.println("id of the thread "+myThread1.getId());
        System.out.println("state of thread "+myThread.getState());//get state method returns current state of the thread
        myThread1.setName("secondThread");
        myThread2.setName("thirdThread");

    }
}
