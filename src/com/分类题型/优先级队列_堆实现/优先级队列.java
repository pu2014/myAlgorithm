package com.分类题型.优先级队列_堆实现;
//优先级队列是用堆实现的，默认为小根堆


import java.util.PriorityQueue;

public class 优先级队列 {
    public static class Student{
        public int id;
        public int age;

        public Student(int id, int age) {
            this.id = id;
            this.age = age;
        }
    }
    public static void main(String[] args){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(4);
        heap.add(3);
        heap.add(5);
        heap.add(9);
        heap.add(0);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }

        /**
        PriorityQueue<Student>  heap1 = new PriorityQueue<>(new Comparator<Student>(){

            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
         */
        PriorityQueue<Student> heap1 = new PriorityQueue<>((o1, o2)-> o1.age - o2.age);
        heap1.add(new Student(1,17));
        heap1.add(new Student(4,2));
        heap1.add(new Student(5,3));
        heap1.add(new Student(2,73));
        heap1.add(new Student(3,54));

        while(!heap1.isEmpty()){
            Student student = heap1.poll();
            System.out.println(student.id + ":" + student.age);
        }
    }
}
