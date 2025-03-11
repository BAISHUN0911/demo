package org.example.infrastructure.algorithm.listnode;

import java.util.ArrayDeque;

/**
 * 翻转链表
 * 1.头插法
 * 2.递归
 * 3.栈
 *
 * @Author BAISHUN
 * @Date: 2024/6/13 23:24
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        // 构建一个链表
        int[] arr = {1,2,3};
        ListNode node = ListNode.buildLinkedList(arr);
//        ListNode res = reverseLinkedListByStack(node);
        ListNode reversed = reverseLinkedListByHeadInsert(node);
//        ListNode reversed = reverseLinkedList(node);
        System.out.println("翻转后的链表为：");
        ListNode.printLinkedList(reversed);
    }

    /**
     * 翻转链表，通过栈
     * 先遍历链表，将每一个节点放在栈中，然后一次弹栈构建翻转后的链表，记得将最后一个节点的next指针指向null
     *
     * @param node 链表头节点
     */
    private static ListNode reverseLinkedListByStack(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        // 将翻转后链表最后元素的next指针指向null
        head.next = null;
        return temp.next;
    }

    /**
     * 翻转链表 头插法
     * 新建一个空链表，遍历一次原链表，将每个节点插到新链表头部
     *
     * @param node 链表头节点
     * @return 翻转后的链表
     */
    private static ListNode reverseLinkedListByHeadInsert(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = head;
            head = node;
            node = next;
        }
        return head;
    }


    /**
     * 递归  1-->2  1<-->2 null<--1<--2
     * 终止条件：当前节点为null或当前节点是最后一个节点
     *
     * @param node 链表头节点
     * @return 翻转后的链表
     */
    private static ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        // 递归翻转剩余部分
        ListNode reversedTail = reverseLinkedList(node.next);
        // 当前节点的next节点的next节点指向自己
        node.next.next = node;
        // 断掉当前节点的next指针，不然就会互相指向
        node.next = null;

        return reversedTail;
    }

}
