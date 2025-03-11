package org.example.infrastructure.algorithm.listnode;

/**
 * @description: 合并两个链表并得到一个升序的链表
 * @Author BAISHUN
 * @Date 2024/8/11 22:13
 */
public class MergeSortedLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 3, 5});
        ListNode l2 = ListNode.buildLinkedList(new int[]{2, 3, 6});
        ListNode listNode = mergeTwoLists(l1, l2);
        ListNode.printLinkedList(listNode);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode current = new ListNode(0);
        ListNode dummy = current;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;
    }
}
