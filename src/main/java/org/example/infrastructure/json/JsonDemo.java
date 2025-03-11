package org.example.infrastructure.json;

import com.alibaba.fastjson.JSON;
import org.example.infrastructure.classextend.Animal;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/26 11:08
 */
public class JsonDemo {
    public static void main(String[] args) {
        String s = "{\"name\":\"mao\"}";
        Animal cat = JSON.parseObject(s, Animal.class);
        System.out.println(cat.toString());
        cat.makeSound();
    }
}
