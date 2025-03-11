package org.example.infrastructure.classextend;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@ExtendWith(MockitoExtension.class)
class AnimalTest {
    private ThreadPoolTaskExecutor executor;

    @Test
    void test1() {
        // 创建父类类型的变量，但实例化为子类对象
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        // 调用 makeSound 方法
        myDog.makeSound(); // 输出 "Bark"
        myCat.makeSound(); // 输出 "Meow"
        // 动态绑定和多态性的体现
        Animal[] animals = {myDog, myCat};
        for (Animal animal : animals) {
            animal.makeSound(); // 根据实际对象类型调用相应的方法
        }
    }

    @Test
    void test2() {
        Animal animal = new Animal();
        animal.makeSound();
    }

    @Test
    void test3() {
        Cat cat = new Cat();
        cat.setName("mao");
        System.out.println(JSON.toJSONString(cat));
    }
}