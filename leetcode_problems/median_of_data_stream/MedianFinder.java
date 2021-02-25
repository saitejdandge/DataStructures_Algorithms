package leetcode_problems.median_of_data_stream;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap, minHeap;

    MedianFinder() {
        maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);
    }

    public void addNum(int value) {

        if (maxHeap.size() == 0) {
            maxHeap.add(value);
        } else if (maxHeap.size() == minHeap.size()) {
            if (value < maxHeap.peek())
                maxHeap.add(value);
            else {
                maxHeap.add(minHeap.poll());
                minHeap.add(value);
            }

        }
        //maxheap is greater than minHeap
        else {
            if (minHeap.size() == 0) {
                if (value >= maxHeap.peek()) {
                    minHeap.add(value);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(value);
                }
            } else if (value > maxHeap.peek()) {
                minHeap.add(value);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(value);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0)
            return -1;
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}