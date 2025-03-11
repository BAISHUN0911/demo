package org.example.infrastructure.classextend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动物类
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 13:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private String name;

    private int age;

    public void makeSound() {
        System.out.println("Some generic animal sound");
        talk();     // protected方法只能在子类中使用
    }

    protected void talk() {
        System.out.println("我是一只动物");
    }
}
