package com.motivity.threadClassMethods;

class Ambulance1 extends Thread
{
    @Override
    public void run() {
        System.out.println("vehicles stopped ");
        for (int i=0;i<5;++i)
        {
            System.out.println("ambulance going");
        }
    }
}
class Vehicles extends Thread
{
    @Override
    public void run() {
        for (int i=0;i<5;++i)
        {
            System.out.println("vehicles moving ");
        }
    }
}

public class SuspendAndResumeEx {

    public static void main(String[] args) {

        Vehicles vehicles=new Vehicles();
        Ambulance1 ambulanceThread=new Ambulance1();

        vehicles.start();
        if(ambulanceThread.isAlive())//isAlive method checks if the thread is alive.if alive return true else false
        {
            vehicles.suspend();//This method is used to suspend the currently running thread temporarily
        }
        else {
            vehicles.resume();//Using the resume() method,you can resume the suspended thread.
        }
        ambulanceThread.start();

    }
}
