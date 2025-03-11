package org.example.infrastructure.classextend;

import java.io.Serializable;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 13:15
 */
public class Cat extends Animal implements Serializable {

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
        talk();
    }

    @Override
    protected void talk() {
        System.out.println("我是猫");
    }
}
