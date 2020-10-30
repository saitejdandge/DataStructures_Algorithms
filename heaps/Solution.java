package heaps;

public class Solution {
    public static void main(String[] args) {

        int min = 10;
        int max = 1000;

        Heap<String> heap = new Heap<>();

        for (int i = 0; i < 110; i++)
            heap.add((int) (Math.random() * (max - min + 1) + min)+"");

        System.out.println("Size of heap " + heap.size());

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

}
