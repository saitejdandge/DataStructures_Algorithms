package leetcode_problems.median_of_data_stream;

public class Main {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(1000);
        System.out.println(medianFinder.findMedian());
    }
}
