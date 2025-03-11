package org.example.infrastructure.algorithm.listnode;

/**
 * @description: 链表反转
 * @Author BAISHUN
 * @Date 2024/8/17 17:57
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(new int[]{1, 2, 3});
        ListNode node = reverse(head);
        ListNode.printLinkedList(node);

    }

    // 1->2
    private static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }

        return node;
    }

    //1->2
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // 1->2->3->4
    // |-------|
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;       // 慢指针每次走一步
            fast = fast.next.next;  // 快指针每次走2步
        }
        return true;
    }

    /* 1->3  2->4 */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

















}
