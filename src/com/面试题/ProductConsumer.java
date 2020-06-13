package com.面试题;

/**
 * @DESC 生产者 消费者
 * @CREATE BY @Author pbj on @Date 2020/6/13 17:08
 */
public class ProductConsumer {
    static final int N = 100;
    static Producer producer = new Producer();
    static Consumer consumer = new Consumer();
    static OurMonitor ourMonitor = new OurMonitor();
    static class Producer extends Thread{
        public void run() {
            int item;
            while (true) {
                item = produce_item();
                ourMonitor.insert(item);
            }
        }

        private int produce_item() {
            //实际生产
            return 0;
        }
    }

    static class Consumer extends Thread{
        public void run(){
            int item;
            while(true){
                item = ourMonitor.remove();
                consumer_item(item);
            }
        }

        private void consumer_item(int item) {
            //实际消费
        }
    }

    static class OurMonitor{
        private int buffer[] = new int[N];
        private int count = 0, lo = 0, hi = 0;

        public synchronized void insert(int val){
            if(count == N) go_to_sleep();
            buffer[hi] = val;
            hi = (hi + 1) % N;
            count = count + 1;
            if(count == 1) notify();
        }

        private void go_to_sleep() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized int remove(){
            int val;
            if(count == 0) go_to_sleep();
            val = buffer[lo];
            lo=(lo + 1) % N;
            count = count - 1;
            if(count == N - 1) notify();
            return val;
        }
    }
}
