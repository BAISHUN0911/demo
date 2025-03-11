package org.example.infrastructure.algorithm.stack;

import java.util.ArrayDeque;

/**
 * @description: 网页的前进后退
 * a-b-c a-b-d
 * @Author BAISHUN
 * @Date 2024/8/31 17:02
 */
public class PageStack {
    private ArrayDeque<String> preStack = new ArrayDeque<>();

    private ArrayDeque<String> afterStack = new ArrayDeque<>();

    // 用户每访问一个页面都存储栈中，注意每次要清空前进栈
    public void push(String page) {
        if (!afterStack.isEmpty()) {
            afterStack.clear();
        }
        preStack.push(page);
    }

    // 后退页面
    public String retreat() {
        if (preStack.isEmpty() || preStack.size() == 1) {
            System.out.println("前面无网页，不可后退");
            return "";
        }
        afterStack.push(preStack.pop());
        return preStack.peek();
    }

    // 前进页面
    public String forward() {
        if (afterStack.isEmpty()) {
            System.out.println("后面没有页面，不可前进");
            return "";
        }
        preStack.push(afterStack.pop());
        return preStack.peek();
    }
}
