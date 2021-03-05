package linked_list;

public class ReverseGroupIterative {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node result = reverseKGroup(head, 3);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }


    static Node reverseKGroup(Node head, int k) {

        Node curr = head;
        Node prev = null, next = null, first = null;
        boolean isFirstPass = true;
        while (curr != null) {
            int count = 0;
            while (count < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else
                first.next = prev;
            first = prev;
        }
        return head;

    }

    private static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }

        Node next;

    }
}
