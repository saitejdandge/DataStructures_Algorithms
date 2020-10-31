package bst;

public class Node<E> {
    Node<E> left;
    Node<E> right;
    E data;

    Node(E data) {
        this.data = data;
    }
}
