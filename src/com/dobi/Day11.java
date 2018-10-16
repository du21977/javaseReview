package com.dobi;



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

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



        //wait/notify机制
        //一般在synchronized内使用，因为wait会释放锁
        //生产者消费者模式
        //lockobj.wait();-----lockobj.notifyAll()

     /////////////////////////////////////////////同步高级//////////////////////////////////////////////////////////////////

 /////////////////////////////////////////////ReentrantLock//////////////////////////////////////////////////////////////////
        //为什么需要线程同步，就是怕多个线程同时访问共享资源，造成冲突，解决办法就是，一个一个来访问，就是加锁
        //synchronized会造成死锁，ReentranLock不会死锁，因为有tryLock获取锁超时会抛异常
        //ReentrantLock可以替代synchronized,
        //ReentrantLock获取锁更安全
        //必须使用try...finnaly保证正确获取和释放锁
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    counter.add(1);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    counter.dec(1);
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.get());


        /////////////////////////////////////////ReadWriteLock/////////////////////////////////////////////////////////////////
        //使用ReadWriteLock可以解决
        //只允许一个线程写入（其他线程不能写入也不能读取）
        //没有写入操作时，多个线程允许同时读，以提高性能，如上面的counter.get()
        //ReadWriteLock:适用条件--同一个实例，大量线程读取，仅有少线程修改---即读多写少的场景
        Counter1 counter1 = new Counter1();
        Thread t11 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    counter1.add(1);
                }
            }
        };

        Thread t21 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    counter1.dec(1);
                }
            }
        };
        t11.start();
        t21.start();
        try {
            t11.join();
            t21.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter1.get());


        /////////////////////////////////////////Condition////////////////////////////////////////////////////////////////

        //Condition: 用于解决 RenentrantLock中的wait,notify问题
        //Condition可以替代wait/notify/notifyAll
        //Condition对象必须从ReentantLock对象获取
        //ReentrantLock+Condition 可以替代 synchronized +wait/notify/notifyAll
        TaskQueue taskQueue = new TaskQueue();
        WorkThread workThread = new WorkThread(taskQueue);
        workThread.start();

        try {
            taskQueue.addTask("杜du");
            Thread.sleep(1000);
            taskQueue.addTask("he su li");
            Thread.sleep(1000);
            taskQueue.addTask("haha");
            Thread.sleep(1000);
            workThread.interrupt();
            workThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");
*/

/////////////////////////////////////////////Concurrent集合///////////////////////////////////////////////////////////////////////////

        //Concurrent中的BlockingQueue阻塞队列(队列为空时，会wait,当队列满了之后也会wait)，不用自己写阻塞队列了,大大提高开发效率
        //BlockingDeque是双向队列

        BlockingQueue<String> taskQueue = new ArrayBlockingQueue<String>(1000);
        ConcurrentWorkThread concurrentWorkThread = new ConcurrentWorkThread(taskQueue);
        concurrentWorkThread.start();

        try {
            taskQueue.add("ddd---");
            Thread.sleep(2000);
            taskQueue.add("小非---");
            Thread.sleep(2000);
            taskQueue.add("和苏---");
            Thread.sleep(2000);
            concurrentWorkThread.interrupt();
            concurrentWorkThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END--");

        //Concurrent同步集合总结
        //List ----------ArrayList ----------------------------------CopyOnWriteArrayList
        //Map ----------HashMap ----------------------------------ConcurrentHashMap
        //Set ----------HashSet  TreeSet---------------------------CopyOnWriteArraySet
        //Queue--------ArrayDeque LinkList-----------------------ArrayBlockingQueue  LinkedBlockingQueue
        //Deque--------ArrayDeque LinkList----------------------- LinkedBlockingDeque


     //////////////////////////////////////////////Atomic///////////////////////////////////////////////////////////////////////
        //AtomicInterger/AtomicLong等
        //原子操作实现了无锁的线程安全
        //适用于计数器、累加器
        //例子
        AtomicCounter atomicCounter = new AtomicCounter();

   ////////////////////////////////////////////////ExecutorService///////////////////////////////////////////////////////////////////////////////








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

/**
 * 守护线程用的
 */
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 *  ReentranLock
 */
class Counter{
    private Lock lock = new ReentrantLock();
    private int value = 0;
    public void add(int m){
        lock.lock();
        try{
            this.value +=m;
        }finally {
            lock.unlock();
        }
    }

    public void dec(int m){
        lock.lock();
        try{
            this.value -=m;
        }finally {
            lock.unlock();
        }
    }

    //获取锁超时会报异常，所以不会造成死锁
    public int get(){
        /*
        lock.lock();
        try {
            return this.value;
        }finally {
            lock.unlock();
        }*/
        try {
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                try {
                    return this.value;
                }finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * ReadWriteLock-----提高ReentrantLock性能
 */
class Counter1{
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock rLock = lock.readLock();
    Lock wLock = lock.writeLock();
    private int value = 0;
    public void add(int m){
        wLock.lock();
        try {
            this.value +=m;
        }finally {
            wLock.unlock();
        }
    }

    public void dec(int m){
        wLock.lock();
        try {
            this.value -=m;
        }finally {
            wLock.unlock();
        }
    }

    public int get(){
        rLock.lock();
        try{
            return this.value;
        }finally {
            rLock.unlock();
        }
    }
}

/////////////////////////////////////////////////Condition///////////////////////////////////////////////////////////
/**
 * Condition 用于解决 RenentrantLock中的wait,notify问题
 *
 **/
class TaskQueue{
    final Queue<String> queue = new LinkedList<>();
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public String getTask() throws InterruptedException {
        lock.lock();
        try{
            while (this.queue.isEmpty()){
                condition.await();//停在这里啦，后面不执行啦
                System.out.println("为空啦");
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

    public void addTask(String name){
        lock.lock();
        try {
            this.queue.add(name);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

class WorkThread extends Thread{
    TaskQueue taskQueue;

    public WorkThread(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            String name;
            try {
                name = taskQueue.getTask();
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("Hello,--"+name);
        }
    }
}
/////////////////////////////////////////////////concurrent集合///////////////////////////////////////////////////////////
/**
 *  Concurrent中的BlockingQueue阻塞队列，不用自己写上面的阻塞队列了
 */
class ConcurrentWorkThread extends Thread{
    BlockingQueue<String> taskQueue;
    public ConcurrentWorkThread(BlockingQueue<String> taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            String name;
            try {
                name = taskQueue.take();
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("Hello,--"+name);
        }
    }
}

////////////////////////////////////////////////Atomic原子操作////////////////////////////////////////////////////

class AtomicCounter {

    private AtomicInteger value = new AtomicInteger();
    public int add(int m){
        return this.value.addAndGet(m);
    }

    public int dec(int m){
        return this.value.addAndGet(-m);
    }

    public int get(){
        return this.value.get();
    }

}