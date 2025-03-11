package org.example.infrastructure.demo;

public interface IDemo1 {
    default void hello() {
        System.out.println("IDemo1 hello");
    }
}
