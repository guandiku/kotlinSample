package com.xiamen.www.myapplication3.kotlin.javatest.duotai;

/**
 * Created by White on 2018/4/22.
 */

public class Test {

    public static void main(String[] args) {
//
//        Cat cat=new Cat();
//        eat(cat);
//
//        Dog dog=new Dog();
//        eat(dog);

        Animal<Cat> cat = new Cat();//向上转型  将猫转化成动物
        cat.returnThis();
        eat(cat);

        Cat cat1 = (Cat) cat;//向下转型，将动物转化成猫，才可以调用猫的特有方法
        cat1.catchMouse();

    }


    public static void eat(Animal<?> animal) {
        animal.eat();
    }

}
