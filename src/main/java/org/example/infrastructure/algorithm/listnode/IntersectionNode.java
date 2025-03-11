package org.example.infrastructure.algorithm.listnode;

import java.util.HashSet;

/**
 * @description: 寻找两个链表的相交点，返回该链表
 * 例如：1->2->3 2->3  相交点为2，这里假设每个相同的值代表同一个链表
 * 会发现规律：在有相交点的情况下，较长的链表一定不以相交的链表开头，相交点一定在两个链表长度对其后
 * 关键点：链表对其。如果两个链表一开始就长度相等，直接同时遍历即可
 * @Author BAISHUN
 * @Date 2024/8/16 16:20
 */
public class IntersectionNode {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node = new ListNode(3);
        // left: 1->3
        left.next = node;
        // right: 2->4
        right.next = new ListNode(4);
        // node: 3->2->4 left: 1->3->2->4
        // 这里看似将相交点放在right链表头部想让right比left长，但与此同时left链表长度也随之增加
        node.next = right;

        ListNode res = getIntersectionNode(left, right);
        System.out.println(res.getVal());
        ListNode.printLinkedList(res);

        ListNode res2 = func2(left, right);
        ListNode.printLinkedList(res);
    }

    /**
     * 使用Set集合寻找两个链表相交点
     *
     * @param left
     * @param right
     * @return
     */
    public static ListNode func(ListNode left, ListNode right) {
        System.out.println("使用Set集合思路1");
        if (left == null || right == null) {
            return null;
        }
        HashSet<ListNode> lSet = new HashSet<>();
        HashSet<ListNode> rSet = new HashSet<>();
        while (left != null || right != null) {
            if (left == right) {
                return left;
            }
            lSet.add(left);
            rSet.add(right);
            if (rSet.contains(left)) {
                return left;
            }
            if (lSet.contains(right)) {
                return right;
            }
            if (left != null) {
                left = left.next;
            }
            if (right != null) {
                right = right.next;
            }
        }
        return null;
    }

    public static ListNode func2(ListNode left, ListNode right) {
        System.out.println("使用Set集合思路2");
        if (left == null || right == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (left != null) {
            set.add(left);
            left = left.next;
        }
        while (right != null) {
            if (set.contains(right)) {
                return right;
            }
            right = right.next;
        }
        return null;
    }

    // 方法：获取链表的长度
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // 方法：寻找两个链表的交点
    public static ListNode getIntersectionNode(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return null;
        }

        int leftLength = getLength(left);
        int rightLength = getLength(right);

        ListNode l = left;
        ListNode r = right;
        /* 关键点：链表对其 */
        if (leftLength > rightLength) {
            for (int i = 0; i < leftLength - rightLength; i++) {
                l = l.next;
            }
        } else {
            for (int i = 0; i < rightLength - leftLength; i++) {
                r = r.next;
            }
        }

        while (l != null && r != null) {
            if (l == r) {
                return l;
            }
            l = l.next;
            r = r.next;
        }

        return null;
    }
}
