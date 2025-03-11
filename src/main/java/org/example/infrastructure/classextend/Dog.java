package org.example.infrastructure.classextend;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 13:15
 */
public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    protected void talk() {
        System.out.println("我是狗");
    }
}
