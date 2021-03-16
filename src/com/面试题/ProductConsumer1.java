package com.面试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @DESC 生产者 消费者
 * @CREATE BY @Author pbj on @Date 2020/6/13 17:08
 */
public class ProductConsumer1 {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Integer Full = 10;
        ProductConsumer1 test1 = new ProductConsumer1();
        Thread t1 = new Thread(test1.new Product(queue, Full));
        Thread t2 = new Thread(test1.new Consumer(queue, Full));
        t1.start();
        t2.start();
    }

    class Product implements Runnable {
        private Queue<Integer> queue;
        private int maxSize;

        public Product(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {

            while(true){
                synchronized(queue){
//                    while (queue.size() == maxSize){
//                        try{
//                            System.out.println("Queue is Full");
//                            queue.wait();
//                        }catch (InterruptedException ie){
//                            ie.printStackTrace();
//                        }
//                    }
//                    int i = new Random().nextInt();
//                    System.out.println("Produce " + i);
//                    queue.add(i);
//                    queue.notifyAll();

                    while(queue.size() == maxSize){
                        try {
                            System.out.println("full。。。。");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        int i = new Random().nextInt();
//                        System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + queue.size());
                        queue.add(i);
                        queue.notifyAll();
                    }

                }
            }
        }
    }
    class Consumer implements Runnable {
        private Queue<Integer> queue;
        private int maxSize;

        public Consumer(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                        try {
                            queue.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }

                        int v = queue.remove();
                        System.out.println("Consume " + v);
                        queue.notifyAll();
                    }
                }
            }
        }
    }

}
