package org.example.infrastructure.generics.order;

/**
 * @description: 订单
 * @Author BAISHUN
 * @Date 2024/8/31 11:47
 */
public class Order<T> {
    private T order;

    public Order(T order) {
        this.order = order;
    }

    public void processOrder() {
        System.out.println("processing: " + order.toString());
    }

}
