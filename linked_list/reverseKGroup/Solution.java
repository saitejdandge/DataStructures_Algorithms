package linked_list.reverseKGroup;

public class Solution {

    public static void main(String[] args) {
        Node node = new Node('1');
        node.next = new Node('2');
        node.next.next = new Node('3');
        node.next.next.next = new Node('4');
        node.next.next.next.next = new Node('5');
        node.next.next.next.next.next = new Node('6');
        node.next.next.next.next.next.next = new Node('7');

        Node res = reverseKGroup(node, 3);
        Node n = res;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    static Node reverseKGroup(Node head, int k) {
        Node start = head, prevNode = null;
        Node node = head, lastTail = null;
        int count = 0;
        Node res = null;
        while (node != null) {
            if (count != 0 && count % k == 0) {
                //breaking the chain
                Node rHead = reverse(start);
                start.next = node;
                if (res == null)
                    res = rHead;
                if (lastTail != null)
                    lastTail.next = node;
                lastTail = node;
                start = node;
                prevNode.next = null;
            }
            prevNode = node;
            node = node.next;
            count++;
        }
        return res;
    }

    static Node reverse(Node head) {
        Node node = head;
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
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
