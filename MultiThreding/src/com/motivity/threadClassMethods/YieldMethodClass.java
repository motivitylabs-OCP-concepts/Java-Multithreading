package com.motivity.threadClassMethods;
class Rapido implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<5;++i)
        {

            System.out.println("waiting for ride");
            Thread.yield();//the child thread will wait until reaming high priority threads was finishing
        }
    }
}
public class YieldMethodClass {
    public static void main(String[] args) {
        Rapido rapido=new Rapido();
        Thread thread=new Thread(rapido);
        thread.start();
        for (int i=1;i<3;++i)
        {
            System.out.println(thread.getState());
            Thread.currentThread().setPriority(2);//if priority of want to wait method is low yield method not wait for execution
            System.out.println("booking rapido ");
        }
    }
}
