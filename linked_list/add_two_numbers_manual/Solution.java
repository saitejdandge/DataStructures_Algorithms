package linked_list.add_two_numbers_manual;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        Node head1 = new Node(5);
        head1.next = new Node(2);
//        head1.next.next = new Node(9);
        Node head2 = new Node(5);
        head2.next = new Node(3);
        Node curr = addTwo(head1, head2);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
        curr = multiplyTwo(head1, head2);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
        curr = factorial(10000);
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }


    }


    public static Node factorial(int n) {
        if (n < 0)
            return null;

        if (n <= 1)
            return new Node(1);

        Node res = new Node(1);
        for (int i = 2; i <= n; i++) {
            res = multiplyWithDigit(res, i);
        }
        return res;
    }

    public static Node addTwo(Node head1, Node head2) {
        int carry = 0;
        Node[] resHead, resTail;
        resHead = new Node[1];
        resTail = new Node[1];
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null)
                sum += head1.val;
            if (head2 != null)
                sum += head2.val;
            addToList(resHead, resTail, sum % 10);
            carry = sum / 10;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if (carry != 0)
            addToList(resHead, resTail, carry);
        return resHead[0];
    }

    private static void addToList(Node[] resHead, Node[] resTail, int val) {
        if (resHead[0] == null) {
            resHead[0] = resTail[0] = new Node(val);
        } else {
            resTail[0].next = new Node(val);
            resTail[0] = resTail[0].next;
        }
    }


    //ASSUME HEAD2 IS ALWAYS SMALL
    public static Node multiplyTwo(Node head1, Node head2) {
        Node curr = head2;
        HashMap<Integer, Node> results = new HashMap<>();
        int counter = 0;
        while (curr != null) {
            results.put(counter++, multiplyWithDigit(head1, curr.val));
            curr = curr.next;
        }

        Node sum = null;
        for (int i = 0; i < results.size(); i++) {
            for (int k = 0; k < i; k++) {
                results.put(i, addZero(results.get(i)));
            }
            sum = addTwo(sum, results.get(i));
        }

        return sum;

    }

    private static Node addZero(Node head) {
        Node node = new Node(0);
        node.next = head;
        head = node;
        return head;
    }

    private static Node multiplyWithDigit(Node head, int digit) {
        Node[] resHead, resTail;
        resHead = new Node[1];
        resTail = new Node[1];
        int carry = 0;
        while (head != null) {
            int sum = (head.val * digit) + carry;
            addToList(resHead, resTail, sum % 10);
            carry = sum / 10;
            head = head.next;

        }
        while (carry != 0) {
            addToList(resHead, resTail, ((int) carry) % 10);
            carry /= 10;
        }
        return resHead[0];
    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
