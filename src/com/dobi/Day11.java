package com.dobi;

/**
 * 多线程
 */
public class Day11 {

    public static void main(String[] args) {
        //一个java程序实际上是一个JVM进程
        //JVM用一个主线程来执行main()方法
        //在main()方法中又可以启动多个线程

        System.out.println("----main  start-----");
        //创建线程
        //方式一:继承Thread
        MyThread myThread = new MyThread();
        myThread.start();

        //方式二：实现Runnable接口
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread thread = new Thread(myThreadRunnable);
        thread.start();

        try {
            thread.join();//等本线程结束才执行下面的代码，即执行完thread线程才继续执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----main  end-----");
    }


    //volatile
    //https://www.jianshu.com/p/157279e6efdb
    //作用：1.线程可见性：共享变量会保存在主内存和工作内存，工作内存变量改变后，何时会写入到主内存是不确定的，由JVM决定，
    //而volatile可以将主内存和工作内存实现同步，工作内存变量改变后，会通知主内存和其他工作内存，然后都从主内存中获取值
    //---每次访问变量时，总是获取主内存的最新值；每次修改变量后，立刻会写到主内存中
    //2.禁止重排序：为了性能优化，JMM在不改变正确语义的前提下，会允许编译器和处理器对指令序列进行重排序





}

/**
 * //方式一:继承Thread
 */
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("----thread----");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
