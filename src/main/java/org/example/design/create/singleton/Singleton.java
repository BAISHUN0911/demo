package org.example.design.create.singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton() {}

    /** 线程不安全，多个线程同时调用会创建重复对象 */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static synchronized Singleton getInstanceV2() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
