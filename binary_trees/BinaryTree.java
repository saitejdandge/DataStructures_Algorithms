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
}
