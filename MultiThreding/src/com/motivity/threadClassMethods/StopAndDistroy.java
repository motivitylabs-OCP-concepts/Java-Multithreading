package com.motivity.threadClassMethods;

class StudentsGroups extends Thread
{
    StudentsGroups(String threadname,ThreadGroup threadGroup)
    {
        start();
    }

    @Override
    public void run() {
        for (int i=0;i<2;++i)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() +
                " finished executing");
    }
}

public class StopAndDistroy {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup parentgroup1 = new ThreadGroup("Parent thread");
        ThreadGroup childgroup2 = new ThreadGroup(parentgroup1, "child thread");

        StudentsGroups studentsthread1=new StudentsGroups("thread1",parentgroup1);
        StudentsGroups studentsthread2=new StudentsGroups("thread2",parentgroup1);
        System.out.println(" child group destroyed is "+childgroup2.isDestroyed());
        studentsthread2.stop();//we can force fully stop the method
        studentsthread1.join();// join method wait until remains  thread terminates or specified  time

        //childgroup2.destroy();
        parentgroup1.destroy();//This thread method destroys the thread group as well as its subgroup
        System.out.println(childgroup2.getName()+" group destroyed");
       System.out.println("child group destroyed is "+childgroup2.isDestroyed());
        System.out.println(parentgroup1.getName()+" group destroyed");

    }
}
