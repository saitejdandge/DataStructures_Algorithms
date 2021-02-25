package leetcode_problems.median_of_data_stream;

public class Main {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(4);

        medianFinder.addNum(3);

        medianFinder.addNum(2);

        medianFinder.addNum(1);
        medianFinder.addNum(8);

        medianFinder.addNum(9);

        medianFinder.addNum(3);


        System.out.println(medianFinder.findMedian());
    }
}
