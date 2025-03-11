package org.example.infrastructure.demo;

import org.example.infrastructure.classextend.Animal;
import org.example.infrastructure.classextend.Cat;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 14:02
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
//        animal.talk();     // protected方法无法外部使用
        Animal cat = new Cat("mimi", 3);
        cat.makeSound();

        try {
            Thread.sleep(1000 * 3);
            System.out.println("sleep over");
            cat.wait();
            System.out.println("wait over");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
