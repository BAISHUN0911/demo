package org.example.design.create.singleton;

/**
 * @description: 单例模式
 * @Author BAISHUN
 * @Date 2024/9/5 13:30
 */
public class Singleton_01 {

    private static Singleton_01 singleton;

    private Singleton_01() {}

    // 如果多个访问者同时去获取对象实例，会创建多个对象
    public static Singleton_01 getInstance() {
        if (singleton != null) {
            return singleton;
        }
        singleton = new Singleton_01();
        return singleton;
    }

    // 使用双重校验锁，线程安全
    public static Singleton_01 getInstanceWithDoubleLock() {
        if (singleton == null) {
            synchronized (Singleton_01.class) {
                if (singleton == null) {
                    singleton = new Singleton_01();
                }
            }
        }
        return singleton;
    }
}

