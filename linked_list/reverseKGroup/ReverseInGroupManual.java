package linked_list.reverseKGroup;

public class ReverseInGroupManual {


    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /*Reverse first k nodes of linked list*/
        ListNode temp = current;
        while (temp != null && count < k) {
            count++;
            temp = temp.next;
        }
        if (count < k)
            return head;

        while (count > 0 && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverseKGroup(next, k);

        // prev is now head of input list
        return prev;

    }

    public static class ListNode {
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

}
