package binary_search.core;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{0, 5, 8, 15, 15, 16, 16, 16, 16, 16, 16, 18};
//        System.out.println( Arrays.binarySearch(a, 4));
        System.out.println(binarySearch(a, 0, a.length - 1, 15));
    }

    //finding the insertion point if element is not found, always returns insertion point i.e first occurence or start cross.
    public static int binarySearch(int[] a, int s, int e, int ele) {
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ele == a[mid]) {
                res = mid;
                e = mid - 1;
            } else if (ele < a[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return res != -1 ? res : s;
    }
}
