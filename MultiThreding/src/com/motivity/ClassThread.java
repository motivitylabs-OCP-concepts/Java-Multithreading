package com.motivity;

import java.util.Scanner;
class Caluculater implements Runnable{
    long num=0;

    public Caluculater(long num) {
        this.num=num;
    }
    public void run()
    {
        long sum=0;
        for (int i=0;i<num;i++)
        {
            sum=sum+num;
        }
        System.out.println(sum);
    }
}
public class ClassThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter number to calculate square");
        long num = sc.nextLong();
   Caluculater caluculater=new Caluculater(num);

   Thread thread=new Thread(caluculater);
   thread.start();

        System.out.println(Thread.activeCount());

         // caluculater.Calsi();
    }
}
