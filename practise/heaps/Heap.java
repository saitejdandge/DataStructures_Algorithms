package practise.heaps;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {

    private final int[] a = new int[10000];

    int lastPost = -1;

    public Heap() {

    }

    public void add(int val) {
        a[++lastPost] = val;
        trickleUp(lastPost);
    }


    public int remove() {
        int val = a[0];
        swap(0, lastPost--);
        trickleDown(0);
        return val;
    }

    public void printHeap() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            System.out.print(a[index] + " ");
            if (leftChild < lastPost)
                queue.add(leftChild);
            if (rightChild < lastPost)
                queue.add(rightChild);

        }
    }

    public boolean isEmpty() {
        return lastPost == -1;
    }

    public int size() {
        return lastPost + 1;
    }

    private void trickleDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left == lastPost && a[i] < a[left]) {
            swap(left, i);
            return;
        } else if (right == lastPost && a[i] < a[right]) {
            swap(right, i);
            return;
        } else if (left >= lastPost || right >= lastPost)
            return;
        else if (a[i] < a[left] || a[i] < a[right]) {

            if (a[left] > a[right]) {
                swap(left, i);
                trickleDown(left);
            } else {
                swap(right, i);
                trickleDown(right);
            }
        }
    }

    private void trickleUp(int lastPost) {
        int parent = (int) Math.floor((lastPost - 1) / 2);
        if (parent < 0)
            return;

        if (a[lastPost] > a[parent]) {
            swap(lastPost, parent);
            trickleUp(parent);
        }
    }

    private void swap(int lastPost, int parent) {
        int temp = a[lastPost];
        a[lastPost] = a[parent];
        a[parent] = temp;
    }

}
