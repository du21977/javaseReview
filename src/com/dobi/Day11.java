package com.dobi;



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 多线程
 */
public class Day11 {

    public static  int LOOP = 10000;
    public  static int count = 0;
    public static  final Object LOCK = new Object();
    //死锁对象
    public static  DeadLockObject deadLockObject = new DeadLockObject();
    public static void main(String[] args) {
        //一个java程序实际上是一个JVM进程
        //JVM用一个主线程来执行main()方法
        //在main()方法中又可以启动多个线程
/*
        System.out.println("----main  start-----");
        //创建线程
        //方式一:继承Thread
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            //等本线程结束才执行下面的代码，即执行完thread线程才继续执行主线程
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //方式二：实现Runnable接口
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread thread = new Thread(myThreadRunnable);
        thread.start();

        try {
            thread.join();//等本线程结束才执行下面的代码，即执行完thread线程才继续执行主线程
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----main  end-----");

        //线程中断
        //thread.interrupt();
        //判断线程是否中断
        //thread.isInterrupted()


/////////////////////////////////////////////volatile关键字/////////////////////////////////////////////////////////////////////
        //volatile
        //https://www.jianshu.com/p/157279e6efdb
        //作用：1.线程可见性：共享变量会保存在主内存和工作内存，工作内存变量改变后，何时会写入到主内存是不确定的，由JVM决定，
        //而volatile可以将主内存和工作内存实现同步，工作内存变量改变后，会通知主内存和其他工作内存，然后都从主内存中获取值
        //---每次访问变量时，总是获取主内存的最新值；每次修改变量后，立刻会写到主内存中
        //当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值
        //2.禁止重排序：为了性能优化，JMM在不改变正确语义的前提下，会允许编译器和处理器对指令序列进行重排序


///////////////////////////////////////////////////守护线程////////////////////////////////////////////////////////////////////////
        //守护线程
        //守护线程是为其他线程服务的线程
        //其他所有非守护线程结束了，守护线程结束，虚拟机退出
        System.out.println("Main start");
        TimerThread t = new TimerThread();
        t.setDaemon(true); //设置为守护线程
        t.start();
        try {
            Thread.sleep(5000);
            System.out.println("Main  end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

   //////////////////////////////////////////线程同步////////////////////////////////////////////////////////////////////////////

        //对共享变量进行写入时，必须是原子操作
        //原子操作是指不能被中断的一个或一系列的操作
        //synchronized 可以解决同步问题
        //问题：synchronized会降低性能
        Thread thread1 = new AddThread();
        Thread thread2 = new DecThread();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);

        //StringBffer是线程安全的，因为他里面的方法都加了synchronized
*/
        ////////////////////////////////////////死锁问题///////////////////////////////////////////////////////////////////
        //死锁：不同线程获取多个不同对象的锁可能导致死锁
        //死锁形成的条件
        //多个线程各自持有不同的锁
        //多个线程各自试图获取对方已经持有的锁
        //双方无限等下去：导致死锁

        //死锁发生后没有任何机制能够解除死锁，只能强制结束JVM进程

        //如何避免死锁
        //线程获取锁的顺序要一致

        Thread aThread = new AThread();
        Thread bThread = new BThread();
        aThread.start();
        bThread.start();
        try {
            aThread.join();
            bThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");
    }


}

/**
 * //方式一:继承Thread
 */
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i=0;i<3;i++){
            System.out.println("----thread----");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 方式二：实现Runnable接口
 */
class MyThreadRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println("----thread--runnable--");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class TimerThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}

/**
 * 线程同步
 */
 class AddThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i< Day11.LOOP; i++){
            synchronized (Day11.LOCK){
                Day11.count+=1;
            }

        }
    }
}

class DecThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0;i<Day11.LOOP;i++){
            synchronized (Day11.LOCK){
                Day11.count-=1;
            }

        }
    }
}


/**
 * 死锁---
 */

class DeadLockObject {
    final Object lockA = new Object();
    final Object lockB= new Object();

    int accountA = 100;
    int accountB = 200;

    public void a2b(int balance){
        synchronized (lockA){
            accountA-=balance;
            synchronized (lockB){
                accountB+=balance;
            }
        }
    }

    public void b2a(int balance){
        synchronized (lockB){
            accountB-=balance;
            synchronized (lockA){
                accountA+=balance;
            }
        }
    }
}

class AThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<Day11.LOOP;i++){
            Day11.deadLockObject.a2b(1);
        }
    }
}

class BThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<Day11.LOOP;i++){
            Day11.deadLockObject.b2a(1);
        }
    }
}