package com.pu.栈列;

public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }
    public String getPetType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                '}';
    }
}

class Dog extends Pet{

    public Dog() {
        super("dog");
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
class Cat extends Pet{
    public Cat(){
        super("cat");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
