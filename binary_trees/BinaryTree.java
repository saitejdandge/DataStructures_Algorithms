package binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

    public Node<E> root;

    public void inOrder() {
        inOrder(root);
    }

    public void iterativePreOrder() {
        if (root == null)
            return;
        Stack<Node<E>> queue = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.pop();
            System.out.println(node.data);
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
        }

    }

    @Override
    public String toString() {
        return serialize(root);

    }

    public Node<E> deSerialize(String serialization) {

        return deSerialize(serialization, 0);
    }

    private Node<E> deSerialize(String a, int i) {
        if (i == a.length())
            return null;
        if (a.charAt(i) == 'x')
            return null;
        Node<E> node = new Node(Integer.parseInt(a.charAt(i) + ""));
        node.left = deSerialize(a, i + 1);
        node.right = deSerialize(a, i + 1);
        return node;
    }

    private String serialize(Node<E> root) {

        if (root == null)
            return "x";

        return root.data + serialize(root.left)  + serialize(root.right);
    }

    public int burnNode(Node<E> root, E val, Queue<Node<E>> queue) {
        if (root == null)
            return 0;

        if (root.data == val) {
            System.out.print(root.data + " ");
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
            return 1;
        }
        int leftAns = burnNode(root.left, val, queue);
        if (leftAns == 1) {
            int size = queue.size();
            for (int i = 0; i < size && !queue.isEmpty(); i++) {
                Node<E> curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);

            }
            System.out.print(root.data + " ");
            if (root.right != null)
                queue.add(root.right);

        }
        int rightAns = burnNode(root.right, val, queue);
        if (rightAns == 1) {
            int size = queue.size();
            for (int i = 0; i < size && !queue.isEmpty(); i++) {
                Node<E> curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);

            }
            System.out.print(root.data + " ");
            if (root.left != null)
                queue.add(root.left);

        }

        while (!queue.isEmpty()) {

            System.out.print(queue.poll().data + ":here ");
        }
        return 0;

    }

    public void spiralTraversal() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node<E> curr = queue.poll();
                System.out.print(curr.data + ":" + count + " ");
                if (count % 2 == 1) {
                    if (curr.right != null)
                        queue.add(curr.right);
                    if (curr.left != null)
                        queue.add(curr.left);
                } else {
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right != null)
                        queue.add(curr.right);
                }
            }
            count++;
        }
    }

    public void diagonalTraversal() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> curr = queue.poll();
            while (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                curr = curr.right;

            }
        }
    }

    public void boundaryTraversal() {
        System.out.print(root.data + " ");
        leftNonLeaf(root.left);
        leafs(root);
        rightNonLeaf(root.right);
    }

    private void leftNonLeaf(Node<E> root) {
        if (root == null)
            return;
        if (root.left != null) {
            System.out.print(root.data + " ");
            leftNonLeaf(root.left);
        } else if (root.right != null) {
            System.out.println(root.data + " ");
            leftNonLeaf(root.right);
        }
    }

    private void rightNonLeaf(Node<E> root) {
        if (root == null)
            return;
        if (root.right != null) {
            rightNonLeaf(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            rightNonLeaf(root.left);
            System.out.print(root.data + " ");
        }

    }

    private void leafs(Node<E> root) {
        if (root == null)
            return;
        leafs(root.left);
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        leafs(root.right);
    }

    public void morrisTraversal() {
        Node<E> curr = root;
        StringBuilder inOrder = new StringBuilder();
        StringBuilder preOrder = new StringBuilder();
        StringBuilder postOrder = new StringBuilder();
        while (curr != null) {
            if (curr.left == null) {
                inOrder.append(curr.data).append(" ");
                preOrder.append(curr.data).append(" ");
                curr = curr.right;

            } else {
                Node<E> pre = getPredecessor(curr);
                if (pre.right == null) {
                    preOrder.append(curr.data).append(" ");
                    pre.right = curr;
                    curr = curr.left;
                } else {

                    inOrder.append(curr.data).append(" ");
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
    }

    public Node<E> getPredecessor(Node<E> curr) {
        Node<E> pre = curr.left;
        while (pre.right != null && pre.right != curr) {
            pre = pre.right;
        }
        return pre;
    }

    public void allOrdersIterative() {

        Stack<Pair> stack = new Stack<>();
        StringBuilder preOrder = new StringBuilder();
        StringBuilder postOrder = new StringBuilder();
        StringBuilder inOrder = new StringBuilder();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            switch (top.state) {
                case 1:
                    preOrder.append(top.node.data).append(" ");
                    top.state++;
                    if (top.node.left != null)
                        stack.push(new Pair(top.node.left, 1));
                    break;
                case 2:
                    inOrder.append(top.node.data).append(" ");
                    top.state++;
                    if (top.node.right != null)
                        stack.push(new Pair(top.node.right, 1));
                    break;

                case 3:
                    postOrder.append(top.node.data).append(" ");
                    stack.pop();
                    break;
            }
        }
        System.out.println(inOrder);
        System.out.println(preOrder);
        System.out.println(postOrder);

    }

    public void iterativeInOrder() {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> node = root;
        boolean done = false;
        while (!done) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (!stack.isEmpty()) {
                    node = stack.pop();
                    System.out.println(node.data);
                    node = node.right;
                } else {
                    done = true;
                }
            }
        }
    }

    public E nexIterativeInOrder(Stack<Node<E>> stack) {
        E output = null;
        Node<E> node = root;
        boolean done = false;
        while (!done) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (!stack.isEmpty()) {
                    node = stack.pop();
                    output = node.data;
                    System.out.println(node.data);
                    done = true;
                    node = node.right;
                } else {
                    done = true;
                }
            }
        }
        return output;
    }

    public void iterativePostOrder() {
        if (root == null)
            return;
        Stack<Node<E>> queue = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.pop();
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);

            System.out.println(node.data);
        }

    }

    private void inOrder(Node<E> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void levelBylevel() {
        if (root == null)
            return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.data);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

    }

    public static class Node<E> {
        public Node<E> left, right;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }

    private class Pair {
        Node<E> node;
        int state;

        Pair(Node<E> node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
