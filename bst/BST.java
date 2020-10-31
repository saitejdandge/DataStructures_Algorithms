package bst;

public class BST<E> {

    private Node<E> root;

    BST() {

    }

    public boolean contains(E obj) {
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node) {
        if (node == null)
            return false;

        Comparable<E> c = (Comparable<E>) obj;
        if (c.compareTo(node.data) == 0)
            return true;
        if (c.compareTo(node.data) <= 0) {
            return contains(obj, node.left);
        }
        return contains(obj, node.right);
    }

    public void add(E value) {
        if (root == null)
            root = new Node<>(value);
        else
            add(value, this.root);
    }

    private void add(E obj, Node<E> node) {

        Comparable<E> c = (Comparable<E>) obj;

        Node<E> newNode = new Node<>(obj);
        if (c.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = newNode;
                return;
            }
            add(obj, node.right);
        } else {
            if (node.left == null) {
                node.left = newNode;
                return;
            }
            add(obj, node.left);
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node<E> node) {
        if (node == null)
            return;
        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);
    }

    public void remove(E obj) {
        if (root == null)
            return;

        root = remove(obj, root);
    }

    private Node<E> remove(E obj, Node<E> node) {

        if (node == null)
            return null;
        Comparable<E> c = (Comparable<E>) obj;

        // less
        if (c.compareTo(node.data) < 0) {
            node.left = remove(obj, node.left);
        } else if (c.compareTo(node.data) > 0) {
            node.right = remove(obj, node.right);
        }
        // current node has to be deleted
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null)
                return node.left;

            node.data = getMin(node.right);
            node.right = remove(node.data, node.right);

        }

        return node;
    }

    private E getMin(Node<E> n) {

        E obj = n.data;
        while (n.left != null) {
            obj = n.left.data;
            n = n.left;
        }

        return obj;

    }
}
