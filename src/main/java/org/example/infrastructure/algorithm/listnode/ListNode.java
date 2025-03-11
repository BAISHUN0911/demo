package org.example.infrastructure.algorithm.listnode;

import lombok.Data;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 链表节点
 *
 * @Author BAISHUN
 * @Date: 2024/6/13 23:22
 */
@Data
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode pre;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    // 构建链表
    public static ListNode buildLinkedList(int[] arr) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int n : arr) {
            head.next = new ListNode(n);
            head = head.next;
        }
        return temp.next;
    }

    // 打印链表
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("当前链表为null");
            return;
        }
        StringJoiner stringJoiner = new StringJoiner("->");
        while (head != null) {
            stringJoiner.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(stringJoiner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next) && Objects.equals(pre, listNode.pre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, pre);
    }
}
