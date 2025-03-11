package org.example.infrastructure.demo;

public abstract class ADemo {
    private static final int x = 1;

    void m1() {
        System.out.println(x);
        System.out.println(ADemo.x);
    }
}
