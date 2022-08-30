package com.motivity.threadClassMethods;

class Institute extends Thread{

    @Override
    public void run() {
        for (int i=0;i<5;++i)
        {
            System.out.println("student coming to institute "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Faculty extends Thread{

    @Override
    public void run() {
        for (int i=0;i<5;++i)
        {
            System.out.println("faculty coming to institute "+i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class DeamonThreadexample {
    public static void main(String[] args) throws InterruptedException {

        Institute institute=new Institute();
        Faculty faculty=new Faculty();
        institute.start();
        faculty.setDaemon(true);//is use set thread is deamon
        System.out.println(faculty.getName()+" is deamon  "+ faculty.isDaemon());//return boolean  demon or not
        faculty.start();
        institute.join();
            System.out.println("students not came to the institute management(JVM) removed faculty forcefully");

    }
}
