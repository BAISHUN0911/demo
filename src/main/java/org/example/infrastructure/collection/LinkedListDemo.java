package org.example.infrastructure.collection;

import java.util.LinkedList;

/**
 * @description: LinkedList：基于双向链表实现，适用于频繁插入和删除操作
 * 实现了 List 接口和 Deque 接口，因此它既可以作为列表使用，也可以作为双端队列使用。
 * LinkedList 内部是通过双向链表实现的，这使得它在插入和删除操作时非常高效，尤其是在列表的开头和结尾处
 * @Author shengy
 * @Date 2025/4/3 10:18
 */
public class LinkedListDemo {
  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("A");
    linkedList.addLast("B");  // 列表末尾添加元素等同于add()
    System.out.println(linkedList);
    linkedList.addFirst("C");
    System.out.println(linkedList);
    linkedList.add(0, "D"); // 等价于addFirst
    System.out.println(linkedList);
    linkedList.remove(0);     // 等价于removeFirst()
    System.out.println(linkedList);
    linkedList.add("A");
    System.out.println(linkedList);
    System.out.println(linkedList.indexOf("A"));
    System.out.println(linkedList.lastIndexOf("A"));
    /**
     * peek()、peekFirst()、peekLast()：返回列表的第一个或最后一个元素，但不移除。
     * poll()、pollFirst()、pollLast()：返回并移除列表的第一个或最后一个元素。元素为null不抛异常
     * removeFirst()、removeLast()：移除并返回列表的第一个元素、最后一个元素 元素为null会抛异常
     * push()、pop()：压栈、弹栈，基于Deque接口特性，双端队列同样适合做栈使用
     */
    linkedList.push("E");
    System.out.println(linkedList);
    System.out.println(linkedList.pop());

  }
}
