package org.example.infrastructure.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Demo extends ADemo implements IDemo1{
    private int value;

    public Demo() {
    }

    public Demo(int value) {
        this.value = value;
    }

    void m1() {
        super.m1();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.m1();
    }
}
