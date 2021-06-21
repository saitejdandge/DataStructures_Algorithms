package linked_list.reverse_words;

public class Solution {

    public static void main(String[] args) {
        Node node = new Node('t');
        node.next = new Node('h');
        node.next.next = new Node('i');
        node.next.next.next = new Node('s');
        node.next.next.next.next = new Node(' ');
        node.next.next.next.next.next = new Node('i');
        node.next.next.next.next.next.next = new Node(' ');
//        node.next.next.next.next.next.next.next = new Node('h');
        reverseWords(node);


    }

    public static void reverseWords(Node head) {
        head = reverse(head);
        Node node = head;
        Node start = node;
        Node result = null;
        Node end = null;
        Node lastE = null;
        while (node != null) {
            if (node.val == ' ') {
                end.next = null;
                Node newHead = reverse(start);
                if (result == null)
                    result = newHead;
                start.next = node;
                start = node.next;
                lastE = node;
            }
            end = node;
            node = node.next;
        }
        if (lastE != null) {
            lastE.next = null;
            lastE.next = reverse(start);
        }
        Node x = result;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

    }

    public static Node reverse(Node head) {
        if (head == null)
            return null;

        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    static class Node {
        char val;
        Node next;

        public Node(char val) {
            this.val = val;
        }
    }
}
