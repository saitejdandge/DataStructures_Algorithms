package linked_list.reverseKGroup;

public class ReverseGroupIterative {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        Node result = reverseKGroup(head, 3);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }


    static Node reverseKGroup(Node head, int k) {

        int n = 0;
        Node curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        if (k > n || k <= 0)
            return head;
        curr = head;
        Node answer = null;
        Node secondConnection = null;
        Node groupHead = head;
        Node firstConnection = null;
        Node revGroupHead;
        for (int i = 0; i < n / k; i++) {
            for (int j = 0; j < k; j++) {
                secondConnection = curr;
                curr = curr.next;
            }
            /*Breaking first and second connections*/
            if (firstConnection != null)
                firstConnection.next = null;
            secondConnection.next = null;

            /*Reversing the broken group*/
            revGroupHead = reverse(groupHead);

            /*Saving the answer*/
            if (answer == null)
                answer = revGroupHead;

            /*Connecting first connection*/
            if (firstConnection != null)
                firstConnection.next = revGroupHead;
            /*Connecting second connection*/
            groupHead.next = curr;

            /*Updation*/
            firstConnection = groupHead;
            groupHead = curr;
        }

        return answer;

    }

    private static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
