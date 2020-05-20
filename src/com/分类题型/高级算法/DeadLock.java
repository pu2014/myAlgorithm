package com.分类题型.高级算法;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/14 11:00
 */
public class DeadLock {
    public static final DeadLock lock1 = new DeadLock();
    public static final DeadLock lock2 = new DeadLock();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " get lock1");
                System.out.println(Thread.currentThread().getName() + " want get lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + " get lock2");
                }
            }
        },"thread one").start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " get lock2");
                System.out.println(Thread.currentThread().getName() + " want get lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                }
            }
        },"thread two").start();
    }

}

