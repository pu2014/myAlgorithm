package com.分类题型.栈列;

import java.util.LinkedList;
import java.util.Queue;

//核心思想：利用封装添加信息量

public class 猫狗队列 {
    //pet类不能改变。只能自己实现一个封装类实现
    public static void main(String[] args) {
        DogCatQueue dcq = new DogCatQueue();
        dcq.add(new Dog());
        dcq.add(new Dog());
        dcq.add(new Cat());
        dcq.add(new Dog());
        System.out.println(dcq.pollAll());
        System.out.println(dcq.pollCat());
        System.out.println(dcq.isCatEmpty());
    }
    public static class PetEnterQueue{
        private Pet pet;
        private long index;
        public PetEnterQueue(Pet pet,long index) {
            this.pet = pet;
            this.index = index;
        }

        public Pet getPet() {
            return pet;
        }

        public long getIndex() {
            return index;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public void setIndex(long index) {
            this.index = index;
        }
        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }
    public static class DogCatQueue {

        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long index;
        //实现add添加cat或者dog类的实例

        public DogCatQueue() {
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.index = 0;
        }

        public void add(Pet pet) {
            if(pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet,this.index++));
            }else if(pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet,this.index++));
            }else{
                throw new RuntimeException("erroe,no dog or cat");
            }
        }

        //pollAll 实现所有实例先后顺序弹出
        public Pet pollAll() {
            if(!this.isDogEmpty() && !this.isCatEmpty()){
                if(this.dogQ.peek().index < this.catQ.peek().index){
                    return this.dogQ.poll().getPet();
                }else{
                    return this.catQ.poll().getPet();
                }
            }else if(!this.isDogEmpty()){
                return this.dogQ.poll().getPet();
            }else if(!this.isCatEmpty()){
                return this.catQ.poll().getPet();
            }else{
                throw new RuntimeException("error,queue is empty!");
            }
        }

        //pollDog
        public Dog pollDog() {
            if(!this.dogQ.isEmpty()){
                return (Dog)dogQ.poll().getPet();
            }else{
                throw new RuntimeException("Error,dogQueue is empty!");
            }
        }


        //pollCat
        public Cat pollCat() {
            if(!this.catQ.isEmpty()){
                return (Cat)catQ.poll().getPet();
            }else{
                throw new RuntimeException("Error,catQueue is empty!");
            }
        }

        //isEmpty
        public boolean isEmpty() {
            return dogQ.isEmpty() && catQ.isEmpty();
        }

        //isDogEmpty
        public boolean isDogEmpty() {
            return dogQ.isEmpty();
        }

        //isCatEmpty
        public boolean isCatEmpty() {
            return catQ.isEmpty();
        }
    }
}
