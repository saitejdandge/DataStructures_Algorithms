package binary_search.rotated_array;

import static binary_search.core.Solution.binarySearch;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 7, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2};
        System.out.println(findCenter(a, 0, a.length - 1));
//        System.out.println(searchInRotatedArray(a, 1));
    }

    public static int searchInRotatedArray(int[] a, int key) {
        int center = findCenter(a, 0, a.length - 1);
        int leftSearch = binarySearch(a, center, a.length - 1, key);
        if (leftSearch != -1)
            return leftSearch;
        else
            return binarySearch(a, 0, center, key);
    }

    public static int findCenter(int[] a, int s, int e) {
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (check(a, s))
                return s;
            if (check(a, e))
                return e;
            if (check(a, mid)) {
                res = mid;
                e = mid - 1;
            } else if (a[s] <= a[mid])
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
