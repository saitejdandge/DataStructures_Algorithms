package sorting.quick_sort;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 9, 5, 5, 7, 8, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int index = partition(a, left, right);
        quickSort(a, left, index - 1);
        quickSort(a, index + 1, right);
    }

    private static int partition(int[] a, int left, int right) {

        int pivotIndex = right ;
        int pivot = a[pivotIndex];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, pivotIndex);
        return pivotIndex;

    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

}