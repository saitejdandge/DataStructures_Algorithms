package linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListI<E> {

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

   public LinkedList() {
        this.currentSize = 0;
    }

    private class Node<E> {
        Node<E> next;
        E data;

        private Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void addLast(E obj) {

        Node<E> node = new Node<>(obj);
        currentSize++;
        if (head == null) {
            // tail is also null
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    @Override
    public void addFirst(E obj) {

        currentSize++;
        Node<E> node = new Node<>(obj);
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    @Override
    public E removeFirst() {
        if (head == null)
            return null;
        E tmp = head.data;
        head = head.next;
        currentSize--;
        return tmp;

    }

    @Override
    public E removeLast() {

        if (head == null)
            return null;
        if (head == tail)
            return removeFirst();

        Node<E> current = head, prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        currentSize--;
        prev.next = null;
        tail = prev;
        return current.data;
    }

    @Override
    public E remove(E obj) {

        Node<E> current = head;
        Node<E> prev = null;

        while (current != null) {
            if (compare(obj, current) == 0) {

                if (current == head)
                    return removeFirst();
                if (current == tail)
                    return removeLast();
                prev.next = current.next;
                return current.data;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E obj) {
        if (head == null)
            return false;
        Node<E> current = head;

        while (current != null) {
            if (compare(obj, current) == 0)
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int compare(E obj, Node<E> node) {
        return ((Comparable<E>) obj).compareTo(node.data);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    private class IteratorHelper implements Iterator<E> {

        private Node<E> index;

        private IteratorHelper() {
            index = head;
        }

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E val = index.data;
            index = index.next;
            return val;
        }

    }

}
