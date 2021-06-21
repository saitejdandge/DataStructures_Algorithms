package binary_search.rotated_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(findCenter(a, 0, a.length - 1));
        System.out.println(searchInRotatedArray(a, 12));
    }

    public static int searchInRotatedArray(int[] a, int key) {
        int center = findCenter(a, 0, a.length - 1);
        int rightSearch = Arrays.binarySearch(a, center, a.length - 1, key);
        if (rightSearch != -1)
            return rightSearch;
        else
            return Arrays.binarySearch(a, 0, center - 1, key);
    }

    public static int findCenter(int[] a, int s, int e) {
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (check(a, mid)) {
                res = mid;
                e = mid - 1;
            } else if (a[s] < a[mid])
                s = mid + 1;
            else
                e = mid - 1;
        }
        return res != -1 ? res : 0;
    }

    public static boolean check(int[] a, int index) {
        int next = (index + 1) % a.length;
        int prev = (index + a.length - 1) % a.length;
        return a[index] < a[next] && a[index] < a[prev];
    }
}
