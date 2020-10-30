package heaps;

public class Heap<E> {

    private int lastPosition = -1;

    private E[] array;

    Heap() {
        array = (E[]) new Object[1000];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return lastPosition + 1;
    }

    public void print() {
        for (E e : array) {
            if (e == null)
                break;
            System.out.print(e + " ");
        }
    }

    public void add(E obj) {
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }

    public E poll() {

        if (lastPosition == -1)
            return null;

        E e = array[0];
        swap(0, lastPosition--);
        trickleDown(0);
        return e;
    }

    private void trickleDown(int parent) {

        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        Comparable<E> c = (Comparable<E>) array[parent];

        // edge cases
        if (left == lastPosition && c.compareTo(array[left]) < 0) {
            swap(left, parent);
            return;
        }

        if (right == lastPosition && c.compareTo(array[right]) < 0) {
            swap(right, parent);
            return;
        }

        if (left >= lastPosition || right >= lastPosition)
            return;

        Comparable<E> leftC = (Comparable<E>) array[left];

        if ((leftC.compareTo(array[right]) > 0) && c.compareTo(array[left]) < 0) {
            swap(left, parent);
            trickleDown(left);
        } else if (c.compareTo(array[right]) < 0) {
            swap(right, parent);
            trickleDown(right);
        }

    }

    private void trickleUp(int position) {

        if (lastPosition < 0)
            return;

        int parent = (int) Math.floor(position - 1.0 / 2);

        if (parent < 0)
            return;

        Comparable<E> c2 = (Comparable<E>) array[position];

        if (c2.compareTo(array[parent]) > 0) {
            swap(position, parent);
            trickleUp(parent);
        }

    }

    public void swap(int from, int to) {
        E obj = array[from];
        array[from] = array[to];
        array[to] = obj;
    }
}
