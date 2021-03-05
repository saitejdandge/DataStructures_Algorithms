package linked_list.oddEven.solution1;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return head;
        int size = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            size++;
        }
        ListNode n = head;
        for (int i = 0; i < size / 2; i++) {
            end.next = n.next;
            n.next = n.next.next;
            end.next.next = null;

            //iterate
            end = end.next;
            n = n.next;
        }
        return head;
    }
}